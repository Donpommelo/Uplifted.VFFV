package dev.zt.UpliftedVFFV.Battle;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.DillyDally;
import dev.zt.UpliftedVFFV.ablities.ItemNothing;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Runaway;
import dev.zt.UpliftedVFFV.ablities.SkillNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.ablities.UseItem;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.Assets;
//import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CatoWantStatus;


public class BattleMenu{
	
	private AudioManager audio;
	
	public int currentlyTargeted;		//Schmuck being targeted for attack, skill use or item use
	public int actionSelected;			//Action chosen 0:Attack | 1: Skill | 2: Item | 3: Wait | 4: Run
		
	public int itemSelected;			//Index of chosen item or SKILL chosen
	public int itemPointer;				//Location of pointer poiting at chosen item or SKILL
	public int backpackLocation;		//Index of item or SKILL that occupies the uppermost space in the menu display
	public int itemnum;					//Used to draw inventory contents
	public int skillnum;				//used to draw skill list
	public int phase;
	public StateManager sm;
	public Game game;
	
	//KeyListener delay variables.
	private int delayCursor = 120;
	private int delaySelection = 300;
	
	//Turned on by pressing "x" anytime. Moves one menu screen backwards. De-selects options.
	public Boolean exit = false; 			
	
	//Whether targeting allies. Turned on/off by pressing up/down in targeting phase.
	public Boolean teamTargeted = false;
	
	//Arraylist of all allies and enemies, targetable or untargetable. (Actual targets: bs.bs.alliesTargets and bs.bs.enemyTargets)
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	
	//The Schmuck who is currently making a move and his target.
	public Schmuck currentSchmuck;
	public Schmuck targetedSchmuck;
	
	//The Schmuck that BattleUI draws a pointer over.
	public Schmuck pointed;
	
	//The Skill currently being chosen.
	public Skills currentSkill;
	
	public BattleState bs;
	public GameState gs;
	public BattleMenu(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy, BattleState bs,Schmuck chosen,GameState gs){
		this.game=game;
		this.sm=sm;
		this.bs=bs;
		this.gs=gs;
		this.allies = party;
		this.enemy = enemy;
		this.currentSchmuck=chosen;
		teamTargeted = false;
		currentlyTargeted=0;
		actionSelected=0;
		phase = 1;
		audio = game.getAudiomanager();
		
		//If the Schmuck chose to Wait in the Planning phase, all onDillyDally statuses activate.
		if(bs.bp.pauseTOQ){
			bs.bp.bt.addScene(currentSchmuck.getName()+" makes "+currentSchmuck.getPronoun(1)+" delayed move!");
			currentSchmuck.onDillyDallyEffects(bs);
		}
		pointed = chosen;
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			if(game.getKeyManager().x){
				audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
				exit=true;
				game.getKeyManager().disable(delayCursor);
			}
		
			switch(phase){
			
			//Phase 1: Selecting options: Attack, skill, item, wait or run.
			case 1:
				if(game.getKeyManager().down){
					if(actionSelected<4){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						actionSelected++;
						game.getKeyManager().disable(delayCursor);
					}
				}
				if(game.getKeyManager().up){
					if(actionSelected>0){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						actionSelected--;
						game.getKeyManager().disable(delayCursor);
					}
				}
				
				//Space selects an action, turning moveSelected on. 
				//attackChosen is turned on unlike item or skill b/c it skips right into targeting phase with no additional selection.
				//Otherwise, whatever menu or targeting depends on the actionSelected which is checked when moveSelected is true
				if(game.getKeyManager().space){
					switch(actionSelected){
					case 0:
						currentSkill = new StandardAttack(0);
						teamTargeted = false;
						phase+=2;
						break;
					case 1:
						phase+=1;
						break;
					case 2:
						phase+=1;
						break;
					case 3:
						currentSkill = new DillyDally(0);
						targetedSchmuck = currentSchmuck;
						phase+=3;
						break;
					case 4:
						currentSkill = new Runaway(0);
						targetedSchmuck = currentSchmuck;
						phase+=3;
						break;
					}
					game.getKeyManager().disable(delaySelection);
				}
				break;
			
			//Phase 2: Selecting which item or skill to use (Only for skill and item options)	
			case 2:
				switch(actionSelected){
				
				//Case 1: Use Skill chosen
				case 1:
					//Space selects the currently highlighted skill if mp is available, turning on skillchosen so you can start targeting
					if(game.getKeyManager().space){
						
						//If Schmuck has no skills, use "Do Nothing"
						if(currentSchmuck.skills.size()==0){
							currentSkill = new SkillNothing(1);
						}
						else{
							//Message for not having Mp while not having the Catalog of Want
							if((int)(currentSchmuck.skills.get(itemSelected).getCost()*(1-currentSchmuck.getMpCost()))>currentSchmuck.tempStats[1]
									&& !bs.bp.stm.checkStatus(currentSchmuck, new CatoWantStatus(100))){
								bs.bp.bt.addScene(currentSchmuck.getName()+" doesn't have the Motivation Points to do that.");
							}
							else{					
								//Sets currentSkill to skill selected.
								currentSkill = currentSchmuck.skills.get(itemSelected);
								
								//This decides whether the targeting cursor starts off on an ally or enemy
								teamTargeted =  currentSkill.startTarget();
								phase++;
							}
						}
						game.getKeyManager().disable(delaySelection);
					}
					
					//Arrow keys navigate the skill menu
					if(game.getKeyManager().up){
						if(itemSelected>0){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemSelected--;
							if(itemPointer==0){
								backpackLocation--;
							}
							else{
								itemPointer--;
							}
							game.getKeyManager().disable(delayCursor);
						}
						
					}
					if(game.getKeyManager().down){
						if(itemSelected<currentSchmuck.skills.size()-1){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemSelected++;
							if(itemPointer==4){
								backpackLocation++;
							}
							else{
								itemPointer++;
							}
							game.getKeyManager().disable(delayCursor);
						}
					}
					break;
				//Case 2: Use Item Chosen	
				case 2:
					if(game.getKeyManager().space){
						//If Backpack is empty, use Nothing.
						if(gs.inventorymanager.backpack.size()==0){
							currentSkill = new ItemNothing(1);
						}
						else{
							audio.playSound("/Audio/option_toggle.wav", false);
							currentSkill = new UseItem(1,gs.inventorymanager.battleItem().keySet().toArray(new Item[999])[itemSelected],gs);
						}
						
						//This decides whether the targeting cursor starts off on an ally or enemy
						teamTargeted = currentSkill.startTarget();
						phase++;			
						game.getKeyManager().disable(delaySelection);
					}
					//Arrow keys navigate Inventory.
					if(game.getKeyManager().up){
						if(itemSelected>0){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemSelected--;
							if(itemPointer==0){
								backpackLocation--;
							}
							else{
								itemPointer--;
							}
							game.getKeyManager().disable(delayCursor);
						}
						
					}
					if(game.getKeyManager().down){
						if(itemSelected<gs.inventorymanager.battleItem().size()-1){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemSelected++;
							if(itemPointer==4){
								backpackLocation++;
							}
							else{
								itemPointer++;
							}
							game.getKeyManager().disable(delayCursor);
						}
					}
					break;
				}
				break;
				
			//Case 3: Targeting
			case 3:
				//If skill initially targets an empty team, the default team targeted is swapped.
				if(teamTargeted){
					if(bs.bs.alliesTargets.isEmpty()){
						teamTargeted = false;
					}
				}
				else{
					if(bs.bs.enemyTargets.isEmpty()){
						teamTargeted = true;
					}
				}
				
				switch(currentSkill.getTargetType()){
				//Case 0: Skill can target any single targetable, non-incapacitated Schmuck
		 		case 0:
		 			//Left and right cycle through targeting members of the targeted team.
		 			if(game.getKeyManager().right){
						if(teamTargeted==false){
							if(currentlyTargeted>0){
								currentlyTargeted--;
								game.getKeyManager().disable(delayCursor);
							}
						}
						else{
							if(currentlyTargeted<bs.bs.alliesTargets.size()-1){
								currentlyTargeted++;
								game.getKeyManager().disable(delayCursor);
							}
						}
					}
					if(game.getKeyManager().left){
						if(teamTargeted==false){
							if(currentlyTargeted<bs.bs.enemyTargets.size()-1){
								currentlyTargeted++;
								game.getKeyManager().disable(delayCursor);
							}
						}
						else {
							if(currentlyTargeted>0){
								currentlyTargeted--;
								game.getKeyManager().disable(delayCursor);
							}
							
						}
					}
					//up and down swap which team is being targeted.
					if(game.getKeyManager().up && teamTargeted==true && !bs.bs.enemyTargets.isEmpty()){
						if(currentlyTargeted>=bs.bs.enemyTargets.size()){
							currentlyTargeted=0;
						}
						else{
							currentlyTargeted=bs.bs.enemyTargets.size()-1-currentlyTargeted;
						}
						teamTargeted=false;
						game.getKeyManager().disable(delayCursor);
					}
					if(game.getKeyManager().down && teamTargeted==false && !bs.bs.alliesTargets.isEmpty()){
						if(currentlyTargeted>=bs.bs.alliesTargets.size()){
							currentlyTargeted=0;
						}
						else{
							currentlyTargeted=bs.bs.alliesTargets.size()-currentlyTargeted-1;
						}
						teamTargeted=true;
						game.getKeyManager().disable(delayCursor);
					}
					//space finalizes selection.
					if(game.getKeyManager().space){
						game.getKeyManager().disable(delaySelection);
						if(teamTargeted){
							targetedSchmuck = bs.bs.alliesTargets.get(currentlyTargeted);
						}
						else{
							targetedSchmuck = bs.bs.enemyTargets.get(currentlyTargeted);
						}
						phase++;
					}
		 			break;
		 		//Case 1: Skill has no target. Automatically targets first enemy and moves on to the next phase.	
		 		case 1:
		 			if(!bs.bp.getSelectableEnemies(currentSchmuck).isEmpty()){
						targetedSchmuck = bs.bp.getSelectableEnemies(currentSchmuck).get(0);
					}
					else{
						targetedSchmuck = currentSchmuck;
					}
			 		phase++;
		 			break;
		 		//Case 2: Rare. Can only target allies, even incapacitated ones. (Used in revives)
		 		case 2:
		 			//Right and Left cycle through all allies in party, regardless of targetability.
		 			if(game.getKeyManager().right){
		 				if(currentlyTargeted<allies.size()-1){
							currentlyTargeted++;
						}
		 				game.getKeyManager().disable(delayCursor);
					}
					if(game.getKeyManager().left){
						if(currentlyTargeted>0){
							currentlyTargeted--;
												}	
						game.getKeyManager().disable(delayCursor);
					}
					//space finalizes selection and moves on to the next phase
					if(game.getKeyManager().space){
						game.getKeyManager().disable(delaySelection);
						targetedSchmuck = allies.get(currentlyTargeted);
			 			phase++;
			 			game.getKeyManager().disable(delaySelection);
					}
		 			break;
		 			//Feel free to add more targeting methods later if needed.
		 		}
				break;
			//Case 4: Performing the finalized action. 	
			case 4:
				//if menu is being called by waiting, the action is in index 0 and will occur instantly.
				if(bs.bp.pauseTOQ){
					if(actionSelected == 3){
						game.getKeyManager().disable(delaySelection);				
						bs.bp.TurnOrderQueue.set(0, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new PassTurn(0),bs));
					}
					else{
						bs.bp.TurnOrderQueue.set(0,new Action(currentSchmuck,targetedSchmuck,currentSkill,bs));
					}
				}
				//otherwise, if in planning stage, move will be added to the TOQ.
				else{
					for(Action a:bs.bp.TurnOrderQueue){
						if(a.getUser() == currentSchmuck){
							bs.bp.TurnOrderQueue.remove(a);
							break;
						}
					}
					bs.bp.TurnOrderQueue.add(new Action(currentSchmuck,targetedSchmuck,currentSkill,bs));
				}
				
				bs.bp.pauseTOQ=false;								//if dillydallying, end dillydally
				
				//Immediately selects next unit to give command to
				if(bs.bp.currentlySelected < allies.size()-1){		
					bs.bp.currentlySelected++;						
				}
				else{
					bs.bp.currentlySelected = 0;
				}
				
				//Checks if all allies have actions queued up yet.
				ArrayList<Schmuck> temp = new ArrayList<Schmuck>();
				for(Schmuck s : bs.bs.alliesSelectable){
					temp.add(s);
				}
				for(Action a :bs.bp.TurnOrderQueue){				//If all allied schmucks have made actions, exit selection
					if(a!=null){
						if(temp.contains(a.user)){
							temp.remove(a.user);
							}
						}
					}
				//If allies have not moved yet, automatically pull up the menu for the next ally.
				if(!temp.isEmpty() && bs.bs.alliesSelectable.contains(allies.get(bs.bp.currentlySelected))){
					bs.bp.bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(bs.bp.currentlySelected),gs);
				}
				//If all allies have moved, no menu is pulled up. Player can press enter to begin battle phase.
				else{
					bs.bp.selected = false;	
				}			
				break;
			}
		}		
	}
			

	public void render(Graphics g) {
		//if exit is used by pressing x, actions will be de-selected. Eveything moves one menu screen back
		if(exit==true){
			switch(phase){
			
			//Phase 1: Selecting Option. 
			case 1:
				//If used in planning phase, character is deselected. BattleMenu is exited. If dilly-dallying, this has no effect.
				if(bs.bp.phase==1){		 
					bs.bp.selected=false;
				}
				break;
			
			//Phase 2: Selecting Skill/Item	
			case 2:
				//Revert back to Option Selecting. All selection variables reset.
				phase--;
				itemSelected = 0;			
				itemPointer = 0;
				backpackLocation = 0;
				break;
				
			//Phase 3: Targeting	
			case 3:
				//If Schmuck is targeting a skill or item, revert to Skill/Item Selection Phase
				if(actionSelected != 0){
					phase--;
				}
				//If Schmuck is targeting a standard attack, revert to option select Phase.
				else{
					phase -=2;
				}
				//Targeting variables reset.
				currentlyTargeted = 0;
				teamTargeted = false;
				break;
			}
			exit=false;
		}
		
		//x,y coordinates of the option select menu
		int menux = currentSchmuck.getX();
		int menuy = currentSchmuck.getY();
		
		//If Selection Option or targeting standard attack, option select menu is visible.
		if(phase == 1 || (phase == 3 && actionSelected == 0)){
			g.setColor(new Color(0, 128, 255, 200));
			//g.setColor(new Color(0, 0, 0, 200));
			g.fillRect(menux, menuy - 40, 110, 160);
			g.setColor(new Color(255, 255, 51, 225));
			g.fillRect(menux, menuy - 40 + 32 * actionSelected, 110, 32);
			g.fillRect(menux , menuy - 65, 110, 25);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(Color.white);
			
			g.drawString(currentSchmuck.getName(), menux, menuy - 50);
//			Utils.drawDialogueBox(g, window, currentSchmuck.getName(), 18, Color.black, 525, 232, 110, 32, true);
			g.drawString("Attack", menux + 55, menuy - 20);
			g.drawString("Skills", menux + 55, menuy + 12);
			g.drawString("Item", menux + 55, menuy + 44);
			g.drawString("Wait", menux + 55, menuy + 76);
			g.drawString("Run", menux + 55, menuy + 108);
//			String[] options = {"Attack", "Skills", "Item", "Wait", "Run"};
//			Utils.drawMenu(g, window, options, Color.black, 18, actionSelected, 540, 256, 100, 160, true, true);
			
			//Displays mini-icons for actions
			switch(actionSelected){
			case 0:
				g.drawImage(Assets.skillIcons[0], menux + 8, menuy - 40, null);
				break;
			case 1:
				g.drawImage(Assets.skillIcons[1], menux + 8, menuy - 8, null);
				break;
			case 2:
				g.drawImage(Assets.skillIcons[4], menux + 8, menuy + 24, null);
				break;
			case 3:
				if(bs.bp.pauseTOQ){
					g.drawImage(Assets.skillIcons[2], menux + 8, menuy + 56, null);
				}
				else{
					g.drawImage(Assets.skillIcons[3], menux + 8, menuy + 56, null);
				}
				break;
			case 4:
				g.drawImage(Assets.skillIcons[5], menux + 8, menuy + 88, null);
				break;
			}
			
		}
		//If selecting skill/item or targeting skill/item, skill or item menu is visible.
		if(phase == 2 || phase == 3){
			switch(actionSelected){
			case 0:
				//If attack is chosen, nothing is displayed, skips right to targeting phase.
				break;
			//Case 1: Use Skill Chosen	
			case 1:
				//if Skill is chosen, a list of skills covers up the actions menu.
				g.setColor(new Color(0, 128, 255, 200));
				//g.setColor(new Color(0, 0, 0, 200));
				g.fillRect(menux, menuy - 40, 120, 160);
				ArrayList<Skills> skills = currentSchmuck.skills;
				g.setColor(new Color(255, 255, 51, 225));
				g.fillRect(menux , menuy - 65, 110, 25);
				g.fillRect(menux, menuy - 25 + 25 * itemPointer, 120, 25);
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(Color.white);
				g.drawString(currentSchmuck.getName(), menux, menuy - 50);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				//If Schmuck has no skills, Do Nothing is displayed.
				if(skills.size()==0){
					g.drawString("Do Nothing", menux + 3, menuy - 10);
				}
				else{
					//Displays list of skill names and mp costs.
					skillnum = 0;        //Keeps track of number of skills                                                                                                                                                                                                                                                                               
					for(int i = backpackLocation; i <= backpackLocation + 4 && i < currentSchmuck.skills.size(); i++){			
						g.setColor(Color.white);
						g.drawString(skills.get(i).getName()+"  "+(int)(skills.get(i).getCost()*(1-currentSchmuck.getMpCost()))+" Mp", menux + 3, menuy - 10 + 25 * (skillnum));
						skillnum++;
					}
					
					//Short descriptions are also visible to the side.
					g.setColor(Color.white);
					g.fillRect(menux + 120, menuy - 35, 125, 75);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(Color.black);
					Stroke oldStroke = ((Graphics2D) g).getStroke();
					((Graphics2D) g).setStroke(new BasicStroke(3));
					g.drawRect(menux + 120, menuy - 35, 125, 75);
					((Graphics2D) g).setStroke(oldStroke);
					int y = menuy - 25;
					for (String line : skills.get(itemSelected).getDescrShort().split("\n")){
						 g.drawString(line, menux + 125, y += g.getFontMetrics().getHeight());
					}			       
				}
				if(backpackLocation!=0){
					g.drawImage(Assets.Uparrow, menux + 60 - Assets.Uparrow.getWidth() / 2, menuy - 50, null);
				}
				if(backpackLocation!=skills.size()-5 && skills.size()>5){
					g.drawImage(Assets.Downarrow, menux + 60 - Assets.Downarrow.getWidth() / 2, menuy + 92, null);
				}				
				break;
			
			//Case 2: Use Item Chosen
			case 2:	
				//Same as skills
				g.setColor(new Color(0, 128, 255, 200));
				//g.setColor(new Color(0, 0, 0, 200));
				g.fillRect(menux, menuy - 40, 120, 160);
				Set<Item> temp = gs.inventorymanager.battleItem().keySet();
				Item[] itemDisplay = temp.toArray(new Item[999]);
				g.setColor(new Color(255, 255, 51, 225));
				g.fillRect(menux, menuy - 65, 110, 25);
				g.fillRect(menux, menuy - 25 + 25 * itemPointer, 120, 25);
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(Color.white);
				g.drawString(currentSchmuck.getName(), menux, menuy - 50);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				if(gs.inventorymanager.backpack.size()==0){
					g.drawString("Nothing x999", menux + 3, menuy - 10);
				}
				else{
					itemnum=0;                                                                                                                                                                                                                                                                                       
					for(int i = backpackLocation; i <= backpackLocation + 4 && i < gs.inventorymanager.backpack.size(); i++){			
						g.setColor(Color.white);
						g.drawString(itemDisplay[i].getName() + "  x" + gs.inventorymanager.backpack.get(itemDisplay[i]), menux + 3, menuy - 10 + 25 * (itemnum));
						itemnum++;
					}	
					g.setColor(Color.white);
					g.fillRect(menux + 120, menuy - 35, 125, 75);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(Color.black);;
					int y = menuy - 25;
					for (String line : itemDisplay[itemSelected].getDescrShort().split("\n")){
						 g.drawString(line, menux + 125, y += g.getFontMetrics().getHeight());
					}
				}
				if(backpackLocation!=0){
					g.drawImage(Assets.Uparrow, menux + 60 - Assets.Uparrow.getWidth() / 2, menuy - 50, null);
				}
				if(backpackLocation!=gs.inventorymanager.battleItem().size()-5 && gs.inventorymanager.battleItem().size()>5){
					g.drawImage(Assets.Downarrow, menux + 60 - Assets.Downarrow.getWidth() / 2, menuy + 92, null);
				}
				break;
				
				//For Wait and run actions, nothing is displayed. An action is instantly queued up instead.
			}
		}
		
		//If in Targeting Phase, a pointer is drawn over target.
		if(phase == 3){
			//pointed is used in BattleUI to draw pointer over. Default set to Schmuck performing action.
			pointed = currentSchmuck;	
			switch(currentSkill.getTargetType()){
			
				//Case 0: Skill can target any single targetable ally or enemy
				case 0:
					if(teamTargeted){
						if(!bs.bs.alliesTargets.isEmpty()){
							pointed = bs.bs.alliesTargets.get(currentlyTargeted);
						}
					}
					else{
						if(!bs.bs.enemyTargets.isEmpty()){
							pointed = bs.bs.enemyTargets.get(currentlyTargeted);
						}
					} 
					break;
					
				//Case 1: Skill is untargetable. Sets pointed to null to not draw a pointer
				case 1:
					pointed = null;
					break;
					
				//Case 2: Skill targets any ally.	
				case 2:
					pointed = allies.get(currentlyTargeted);
					break;
				}	
		}
	}
}

