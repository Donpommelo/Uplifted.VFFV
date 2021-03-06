package dev.zt.UpliftedVFFV.Battle;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
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
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class BattleMenuRetired{
	
//	public int currentlySelected;
	
	public int currentlyTargeted;		//Schmuck being targeted for attack, skill use or item use
	public int actionSelected;			//Action chosen 0:Attack | 1: Skill | 2: Item | 3: Wait | 4: Run
//	public int skillSelected;			
	public int itemSelected;			//Index of chosen item or SKILL chosen
	public int itemPointer;				//Location of pointer poiting at chosen item or SKILL
	public int backpackLocation;		//Index of item or SKILL that occupies the uppermost space in the menu display
	public int itemnum;					//Used to draw inventory contents
	public int skillnum;				//used to draw skill list
	public int TurnOrderQueue;			//Location in the TOQ an action is to be added to
	public StateManager sm;
	public Game game;
	
	//Turned on by pressing "x" anytime. Moves one menu screen backwards. De-selects options.
	public Boolean exit = false; 			
	
	//Turned on when choosing "Attack", "Skill", or "Item". Turned off when target is selected
	public Boolean moveSelected = false; 	
	
	//Turned on when choosing to attack or which item/skill to use. Begins targeting when on. Turned off by exit.
	public Boolean itemChosen = false;		
	public Boolean attackChosen = false;
	public Boolean skillChosen = false;
	
	//Whether targeting allies. Turned on/off by pressing up/down in targeting phase.
	public Boolean teamTargeted = false;
	
	//Pointer that appears over the head of whoever is being targeted
	public BufferedImage pointer = Assets.pointer;
	
	//Arraylist of all allies and enemies, targetable or untargetable. (Actual targets: bs.bs.alliesTargets and bs.bs.enemyTargets)
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	
	//The Schmuck who is currently making a move and his target.
	public Schmuck currentSchmuck;
	public Schmuck targetedSchmuck;
	
	//The Skill currently being chosen.
	public Skills currentSkill;
	
	public BattleState bs;
	public GameState gs;
	public BattleMenuRetired(Game game, StateManager sm, ArrayList<Schmuck>party,ArrayList<Schmuck>enemy, BattleState bs,Schmuck chosen,GameState gs){
		this.game=game;
		this.sm=sm;
		this.bs=bs;
		this.gs=gs;
		this.allies = party;
		this.enemy = enemy;
		this.currentSchmuck=chosen;
//		currentlySelected=0;
		currentlyTargeted=0;
		actionSelected=0;
		TurnOrderQueue=0;
		
	}

	public void tick() {
		if(game.getKeyManager().x){
			exit=true;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//if item, attack or skill options are chosen, targeting begins depending on the skill (arrow keys)
		//0: All targets
		//1: No target: automatically performs action
		//2: All targetable allies (used for reviving)

		if(itemChosen==true || attackChosen==true || skillChosen==true){
			
	 		switch(currentSkill.getTargetType()){
	 		case 0:
	 			if(game.getKeyManager().right){
					if(teamTargeted==false){
						if(currentlyTargeted>0){
							currentlyTargeted--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					else{
						if(currentlyTargeted<bs.bs.alliesTargets.size()-1){
							currentlyTargeted++;
						}
					}
					
				}
				if(game.getKeyManager().left){
					if(teamTargeted==false){
						if(currentlyTargeted<bs.bs.enemyTargets.size()-1){
							currentlyTargeted++;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						
						}
					else {
						if(currentlyTargeted>0){
							currentlyTargeted--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
				if(game.getKeyManager().up && teamTargeted==true){
					if(currentlyTargeted>=bs.bs.enemyTargets.size()){
						currentlyTargeted=0;
					}
					else{
						currentlyTargeted=bs.bs.enemyTargets.size()-1-currentlyTargeted;
					}
					teamTargeted=false;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				if(game.getKeyManager().down && teamTargeted==false){
					if(currentlyTargeted>=bs.bs.alliesTargets.size()){
						currentlyTargeted=0;
					}
					else{
						currentlyTargeted=bs.bs.alliesTargets.size()-currentlyTargeted-1;
					}
					teamTargeted=true;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
	 			break;
	 		case 1:
	 			bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),currentSkill,bs));
	 			moveSelected=false;
				bs.bp.pauseTOQ=false;
				if(bs.bp.currentlySelected < bs.bs.alliesTargets.size()-1){
					bs.bp.currentlySelected++;
				}
				else{
					bs.bp.currentlySelected = 0;
				}
				for(Action a :bs.bp.TurnOrderQueue){
					if(a!=null){
						if(bs.bs.alliesTargets.get(bs.bp.currentlySelected).equals(a.user)){
							bs.bp.selected=false;
						}
					}
				}
				
//				bs.bp.bm = new BattleMenuv2(game,sm,allies,enemy,bs,bs.bs.alliesTargets.get(bs.bp.currentlySelected),gs);
	 			break;
	 		case 2:
	 			if(game.getKeyManager().right){
					if(teamTargeted==false){
						if(currentlyTargeted>0){
							currentlyTargeted--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					else{
						if(currentlyTargeted<allies.size()-1){
							currentlyTargeted++;
						}
					}
					
				}
				if(game.getKeyManager().left){
					if(teamTargeted==false){
						if(currentlyTargeted<enemy.size()-1){
							currentlyTargeted++;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						
						}
					else {
						if(currentlyTargeted>0){
							currentlyTargeted--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
	 			break;
	 		}
	 		
	 		if(game.getKeyManager().space){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	 		}
			
		}
		
		//movesSelected turned on when pressing space to select attack, skill or item. Turned off when pressing space again to
		//choose a specific skill item or target.
		if(moveSelected==true){
			
			//if menu is being called by waiting, the action is in index 0 and will occur instantly.
			if(bs.bp.pauseTOQ){
				TurnOrderQueue=0;
			}
			//otherwise, if in planing stage, move will be placed according to user's sorted space in the TOQ
			else{
				TurnOrderQueue=bs.bp.currentlySelected;
			}
			
			//Depending on whether attack, item or skill is chosen, an action is placed in the TOQ.
			//Target is already highlighted. Can be moved around at same time.
			switch(actionSelected){
			case 0:	
				if(attackChosen==true){
					
					//Pressing space will set an attack action into the TOQ
					if(game.getKeyManager().space){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						//This determines whether the index targeted is allied or enemy
						if(teamTargeted==false){
							bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new StandardAttack(0),bs));
						}
						else{
							bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new StandardAttack(0),bs));
						}
				
						moveSelected=false;									//Exits selection menu
						bs.bp.pauseTOQ=false;								//if dillydallying, end dillydally
						if(bs.bp.currentlySelected < bs.bs.alliesTargets.size()-1){		//Immediately selects next unit to give command to
							bs.bp.currentlySelected++;						
						}
						else{
							bs.bp.currentlySelected = 0;
						}
						for(Action a :bs.bp.TurnOrderQueue){				//If all allied schmucks have made actions, exit selection
							if(a!=null){
								if(bs.bs.alliesTargets.get(bs.bp.currentlySelected).equals(a.user)){
									bs.bp.selected=false;
								}
							}
						}
						
						//Opens new menu for newly selected schmuck. If all schmucks are done, bs.bp.selected will be false and
						//the new battlemenu will not be ticked/rendered
//						bs.bp.bm = new BattleMenuv2(game,sm,allies,enemy,bs,bs.bs.alliesTargets.get(bs.bp.currentlySelected),gs);
					}
				}
				
				
				break;
			case 1:
				
				//Skills and items have an extra selection menu to pick which skill/item to use before targeting
				if(skillChosen==true){
					if(game.getKeyManager().space){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						//If you have no skills, pressing space will add a do-nothing skill
						ArrayList<Skills> skills = currentSchmuck.skills;
						if(currentSchmuck.skills.size()==0){
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new SkillNothing(1,gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new SkillNothing(1,gs),bs));

							}
						}
						
						//otherwise, your selected action will be added to the TOQ.
						else{
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),skills.get(itemSelected),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),skills.get(itemSelected),bs));
							}
						}
						moveSelected=false;
						bs.bp.pauseTOQ=false;
						if(bs.bp.currentlySelected < allies.size()-1){
							bs.bp.currentlySelected++;
						}
						else{
							bs.bp.currentlySelected = 0;
						}
						for(Action a :bs.bp.TurnOrderQueue){
							if(a!=null){
								if(allies.get(bs.bp.currentlySelected).equals(a.user)){
									bs.bp.selected=false;
								}
							}
						}
						
//						bs.bp.bm = new BattleMenuv2(game,sm,allies,enemy,bs,allies.get(bs.bp.currentlySelected),gs);
					}
				}
				
				//if "use skill" is chosen but no skill has been selected yet, the player can select a skill out of the chosen 
				//schmuck's list of skills.
				//pressing x will return to the action selection menu
				else{
				if(game.getKeyManager().x){
					exit=true;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				//Space selects the currently highlighted skill if mp is available, turning on skillchosen so you can start targeting
				if(game.getKeyManager().space){
					if(currentSchmuck.skills.get(itemSelected).getCost()>currentSchmuck.tempStats[1]){
						bs.bp.bt.textList.add(currentSchmuck.getName()+" doesn't have the Motivation Points to do that.");
					}
					else{
						skillChosen=true;
						
						//This decides whether the targeting cursor starts off on an ally or enemy
						if(!currentSchmuck.skills.isEmpty()){
							currentSkill = currentSchmuck.skills.get(itemSelected);
							teamTargeted =  currentSkill.startTarget(); // do to other stuff
						}
					}
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				//Arrow keys navigate the skill menu
				if(game.getKeyManager().up){
					if(itemSelected>0){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						itemSelected--;
						if(itemPointer==0){
							backpackLocation--;
						}
						else{
							itemPointer--;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				if(game.getKeyManager().down){
					if(itemSelected<currentSchmuck.skills.size()-1){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						itemSelected++;
						if(itemPointer==4){
							backpackLocation++;
						}
						else{
							itemPointer++;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				}
				break;
			case 2:
				
				//Item selection works pretty much like skill selection. just read that instead, ok?
				if(itemChosen==true){
					if(game.getKeyManager().space){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						Set<Item> temp = gs.inventorymanager.battleItem().keySet();
						Item[] itemDisplay= temp.toArray(new Item[999]);
						if(gs.inventorymanager.backpack.size()==0){
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new ItemNothing(1),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new ItemNothing(1),bs));

							}
						}
						else{
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new UseItem(1,itemDisplay[itemSelected],gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new UseItem(1,itemDisplay[itemSelected],gs),bs));
							}
						}
						moveSelected=false;
						bs.bp.pauseTOQ=false;
						if(bs.bp.currentlySelected < allies.size()-1){
							bs.bp.currentlySelected++;
						}
						else{
							bs.bp.currentlySelected = 0;
						}
						for(Action a :bs.bp.TurnOrderQueue){
							if(a!=null){
								if(allies.get(bs.bp.currentlySelected).equals(a.user)){
									bs.bp.selected=false;
								}
							}
						}
						
//						bs.bp.bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(bs.bp.currentlySelected),gs);
					}
				}
				else{
				if(game.getKeyManager().x){
					exit=true;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().space){
					itemChosen=true;
					currentSkill = new UseItem(1,gs.inventorymanager.backpack.keySet().toArray(new Item[999])[itemSelected],gs);
					teamTargeted = currentSkill.startTarget();
//					moveSelected=false;									
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().up){
					if(itemSelected>0){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						itemSelected--;
						if(itemPointer==0){
							backpackLocation--;
						}
						else{
							itemPointer--;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
				if(game.getKeyManager().down){
					if(itemSelected<gs.inventorymanager.backpack.size()-1){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						itemSelected++;
						if(itemPointer==4){
							backpackLocation++;
						}
						else{
							itemPointer++;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				}
				break;
			case 3:
				
				//if "Wait" is chosen, an extra pause at the beginning is given to prevent multiclicking as actions will be performed
				//instantly. Change this later when keylistener is updated
				try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
					//Checks if this menu is called in battle or planning phase.
					//if BattlePhase, turn is passed. Otherwise a "DillyDally" is added to TOQ.
					//"DillyDally" calls up another battlemenu during the Battle Phase when used to delay decision making
					if(bs.bp.pauseTOQ){
						bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new PassTurn(0),bs));
					}
					else{
						bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new DillyDally(0),bs));
					}
					moveSelected=false;
					bs.bp.pauseTOQ=false;
					if(bs.bp.currentlySelected < allies.size()-1){
						bs.bp.currentlySelected++;
					}
					else{
						bs.bp.currentlySelected = 0;
					}
					for(Action a :bs.bp.TurnOrderQueue){
						if(a!=null){
							if(allies.get(bs.bp.currentlySelected).equals(a.user)){
								bs.bp.selected=false;
							}
						}
					}
					
//					bs.bp.bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(bs.bp.currentlySelected),gs);
				break;
				
			case 4:
				//If "Run" is chosen, a runaway action is added. Running takes initiative and can end the fight.
				//Runaway is queued up as a normal action.
				bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new Runaway(0),bs));
				moveSelected=false;
				bs.bp.pauseTOQ=false;
				if(bs.bp.currentlySelected < allies.size()-1){
					bs.bp.currentlySelected++;
				}
				else{
					bs.bp.currentlySelected = 0;
				}
				for(Action a :bs.bp.TurnOrderQueue){
					if(a!=null){
						if(allies.get(bs.bp.currentlySelected).equals(a.user)){
							bs.bp.selected=false;
						}
					}
				}
				
//				bs.bp.bm = new BattleMenu(game,sm,allies,enemy,bs,allies.get(bs.bp.currentlySelected),gs);
				break;
			
			}
		}
		
		//If a move hasn't been selected yet, arrow keys and space will choose an action out of the following
		//Action chosen 0:Attack | 1: Skill | 2: Item | 3: Wait | 4: Run
		else{
			if(game.getKeyManager().down){
				if(actionSelected<4){
					actionSelected++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().up){
				if(actionSelected>0){
					actionSelected--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			//Space selects an action, turning moveSelected on. 
			//attackChosen is turned on unlike item or skill b/c it skips right into targeting phase with no additional selection.
			//Otherwise, whatever menu or targeting depends on the actionSelected which is checked when moveSelected is true
			if(game.getKeyManager().space){
				moveSelected=true;

				switch(actionSelected){
				case 0:
					attackChosen=true;
					currentSkill = new StandardAttack(0);
					break;
				case 1:
	//				skillChosen=true;
					break;
				case 2:
	//				itemChosen=true;
					break;
				case 3:
					currentSkill = new DillyDally(0);
					break;
				case 4:
					currentSkill = new Runaway(0);
					break;
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			

	}
			

	public void render(Graphics g) {
		
		//if exit is used by pressing x, actions will be de-selected. Eveything moves one menu screen back
		if(exit==true){
			currentlyTargeted = 0;			//Resets targeting
			if(attackChosen==true){			//attack, item and skill are deselected
				attackChosen=false;
				moveSelected=false;
			}
			else if(itemChosen==true){
				itemChosen=false;
			}
			else if(skillChosen==true){
				skillChosen=false;
			}
			else if(moveSelected==true){	 
				moveSelected=false;
				itemSelected = 0;			
				itemPointer = 0;
				backpackLocation = 0;
			}	
			else if(bs.bp.phase==1){		//If used in planning phase, character is deselected. 
					bs.bp.selected=false;
				
			}
			exit=false;
		}
		
		//Menu in lower-right corner displays action options. This always appears when a battlemenu is pulled up.
		g.setColor(new Color(102, 178,255));
		g.fillRect(540, 256,100,160);
		g.setColor(new Color(255, 255,51));
		g.fillRect(540,256+32*actionSelected, 100, 32);
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.setColor(new Color(0, 0,0));
		
		g.drawString("Attack", 540, 283);
		g.drawString("Skills", 540, 315);
		g.drawString("Item", 540, 347);
		g.drawString("Wait", 540, 379);
		g.drawString("Run", 540, 411);
		
		//Displays mini-icons for actions
		switch(actionSelected){
		case 0:
			g.drawImage(Assets.attack, 610, 256, null);
			break;
		case 1:
			g.drawImage(Assets.skill, 610, 288, null);
			break;
		case 2:
			g.drawImage(Assets.item, 610, 320, null);
			break;
		case 3:
			if(bs.bp.pauseTOQ){
				g.drawImage(Assets.nothing, 610, 352, null);
			}
			else{
				g.drawImage(Assets.wait, 610, 352, null);
			}
			break;
		case 4:
			g.drawImage(Assets.run, 610, 384, null);
			break;
		}
		
		//if an action has been selected, menus may be pulled up depending on which action was chosen
		if(moveSelected){
			switch(actionSelected){
			case 0:
				//If attack is chosen, nothing is displayed, skips right to targeting phase
				break;
			case 1:
				//if Skill is chosen, a list of skills covers up the actions menu
				g.setColor(new Color(102, 178,255));
				g.fillRect(500, 210, 140, 206);
				g.setColor(new Color(102, 178,255));
				g.fillRect(500, 210, 140, 206);
				ArrayList<Skills> skills = currentSchmuck.skills;
				g.setColor(new Color(255, 255,51));
				g.fillRect(500, 216+25*itemPointer, 140, 25);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				g.setColor(new Color(0, 0,0));
				if(skills.size()==0){
					g.drawString("Do Nothing", 505, 231);
				}
				else{
					
					//Displays list of skill names and mp costs
					skillnum=0;                                                                                                                                                                                                                                                                                       
					for(int i=backpackLocation;i<=backpackLocation+4 && i<skills.size();i++){			
						g.setColor(new Color(0, 0,0));
						g.drawString(skills.get(i).getName()+"  "+skills.get(i).getCost()+" Mp", 505, 231+25*(skillnum));
						skillnum++;
					}
					
					//Short descriptions are also visible at the bottom
					g.setColor(new Color(255, 255,255));
					g.fillRect(505, 340, 130, 76);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(new Color(0, 0,0));
					int y=340;
					for (String line : skills.get(itemSelected).getDescrShort().split("\n")){
						 g.drawString(line, 505, y += g.getFontMetrics().getHeight());
					}			       
				}
			if(backpackLocation!=0){
				g.drawImage(Assets.Uparrow,570,209,null);
			}
			if(backpackLocation!=skills.size()-5 && skills.size()>5){
				g.drawImage(Assets.Downarrow,570,334,null);
			}				
				break;
			case 2:	
				
				//Same as skills
				g.setColor(new Color(102, 178,255));
				g.fillRect(500, 210, 140, 206);
				Set<Item> temp = gs.inventorymanager.battleItem().keySet();
				Item[] itemDisplay = temp.toArray(new Item[999]);
				g.setColor(new Color(255, 255,51));
				g.fillRect(500, 216+25*itemPointer, 140, 25);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				g.setColor(new Color(0, 0,0));
				if(gs.inventorymanager.backpack.size()==0){
					g.drawString("Nothing x999", 505, 231);
				}
				else{
					itemnum=0;                                                                                                                                                                                                                                                                                       
					for(int i=backpackLocation;i<=backpackLocation+4 && i<gs.inventorymanager.backpack.size();i++){			
						g.setColor(new Color(0, 0,0));
						g.drawString(itemDisplay[i].getName()+"  x"+gs.inventorymanager.backpack.get(itemDisplay[i]), 505, 231+25*(itemnum));
						itemnum++;
					}	
					g.setColor(new Color(255, 255,255));
					g.fillRect(505, 340, 130, 76);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(new Color(0, 0,0));
					int y=340;
					for (String line : itemDisplay[itemSelected].getDescrShort().split("\n")){
						 g.drawString(line, 505, y += g.getFontMetrics().getHeight());
					}
				}
			if(backpackLocation!=0){
				g.drawImage(Assets.Uparrow,570,209,null);
			}
			if(backpackLocation!=gs.inventorymanager.backpack.size()-5 && gs.inventorymanager.backpack.size()>5){
				g.drawImage(Assets.Downarrow,570,334,null);
			}
				break;
				
				//For Wait and run actions, nothing is displayed. An action is instantly queued up instead.
		}
		
			
		}
		
		//Cursor drawn over head of targeted unit
		if(itemChosen==true || attackChosen==true || skillChosen==true){
			switch(currentSkill.getTargetType()){
			case 0:
				if(teamTargeted){
					g.drawImage(pointer,bs.bs.alliesTargets.get(currentlyTargeted).getBattleSprite().getWidth()/2+bs.bs.alliesTargets.get(currentlyTargeted).getX()-16,bs.bs.alliesTargets.get(currentlyTargeted).getY()-10,null);
				}
				else{
					g.drawImage(pointer,bs.bs.enemyTargets.get(currentlyTargeted).getBattleSprite().getWidth()/2+bs.bs.enemyTargets.get(currentlyTargeted).getX()-16, bs.bs.enemyTargets.get(currentlyTargeted).getY()-10,null);
				}
				g.setColor(new Color(102, 178,255));
				g.fillRect(520, 0,140,25);
				if(teamTargeted){
					g.setColor(new Color(0, 0,0));
					g.drawString(bs.bs.alliesTargets.get(currentlyTargeted).getName()+" ",520,20);
				}
				else{
					g.setColor(new Color(0, 0,0));
					g.drawString(bs.bs.enemyTargets.get(currentlyTargeted).getName()+" ",520,20);
				}
				break;
			case 1:
				break;
			case 2:
				if(teamTargeted){
					g.drawImage(pointer,allies.get(currentlyTargeted).getBattleSprite().getWidth()/2+allies.get(currentlyTargeted).getX()-16,allies.get(currentlyTargeted).getY()-10,null);
				}
				else{
					g.drawImage(pointer,enemy.get(currentlyTargeted).getBattleSprite().getWidth()/2+enemy.get(currentlyTargeted).getX()-16, enemy.get(currentlyTargeted).getY()-10,null);
				}
				g.setColor(new Color(102, 178,255));
				g.fillRect(520, 0,140,25);
				if(teamTargeted){
					g.setColor(new Color(0, 0,0));
					g.drawString(allies.get(currentlyTargeted).getName()+" ",520,20);
				}
				else{
					g.setColor(new Color(0, 0,0));
					g.drawString(enemy.get(currentlyTargeted).getName()+" ",520,20);
				}
				break;
			}
			
			
			//Name of target displayed in upper right corner.
			
			
			//i forgot what this was for. dammit.
			itemnum++;
		}
	
		

		
	}



}
