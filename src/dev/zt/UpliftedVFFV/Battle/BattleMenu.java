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
//import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.CatoWantStatus;
//import dev.zt.UpliftedVFFV.utils.Utils;


public class BattleMenu{
	
	public int currentlyTargeted;		//Schmuck being targeted for attack, skill use or item use
	public int actionSelected;			//Action chosen 0:Attack | 1: Skill | 2: Item | 3: Wait | 4: Run
		
	public int itemSelected;			//Index of chosen item or SKILL chosen
	public int itemPointer;				//Location of pointer poiting at chosen item or SKILL
	public int backpackLocation;		//Index of item or SKILL that occupies the uppermost space in the menu display
	public int itemnum;					//Used to draw inventory contents
	public int skillnum;				//used to draw skill list
	public int TurnOrderQueue;			//Location in the TOQ an action is to be added to
	public int phase;
	public StateManager sm;
	public Game game;
//	private BufferedImage window;
	
	//Turned on by pressing "x" anytime. Moves one menu screen backwards. De-selects options.
	public Boolean exit = false; 			
	
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
		currentlyTargeted=0;
		actionSelected=0;
		TurnOrderQueue=0;
		phase = 1;
//		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		if(bs.bp.pauseTOQ){
			for(int i=0; i<currentSchmuck.statuses.size(); i++){
				if(currentSchmuck.statuses.get(i)!=null){
					currentSchmuck.statuses.get(i).onDillyDally(currentSchmuck,bs);
				}	
			}
		}
		pointed = chosen;
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
		
		switch(phase){
		case 1:
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
				switch(actionSelected){
				case 0:
					currentSkill = new StandardAttack(0);
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
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		case 2:
			switch(actionSelected){
			case 1:
				//Space selects the currently highlighted skill if mp is available, turning on skillchosen so you can start targeting
				if(game.getKeyManager().space){
					if(currentSchmuck.skills.size()==0){
						currentSkill = new SkillNothing(1,gs);
					}
					else{
						if((int)(currentSchmuck.skills.get(itemSelected).getCost()*(1+currentSchmuck.getMpCost()))>currentSchmuck.tempStats[1]
								&& !bs.bp.stm.checkStatus(currentSchmuck, new CatoWantStatus(currentSchmuck, 100))){
							bs.bp.bt.textList.add(currentSchmuck.getName()+" doesn't have the Motivation Points to do that.");
						}
						else{
												
							//This decides whether the targeting cursor starts off on an ally or enemy
							if(!currentSchmuck.skills.isEmpty()){
								currentSkill = currentSchmuck.skills.get(itemSelected);
								teamTargeted =  currentSkill.startTarget(); // do to other stuff
							}
							phase++;
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
				break;
			case 2:
				if(game.getKeyManager().space){
					if(gs.inventorymanager.backpack.size()==0){
						currentSkill = new ItemNothing(1,gs);
					}
					else{
						currentSkill = new UseItem(1,gs.inventorymanager.battleItem().keySet().toArray(new Item[999])[itemSelected],gs);
					}
					teamTargeted = currentSkill.startTarget();
					phase++;			
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
					if(itemSelected<gs.inventorymanager.battleItem().size()-1){
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
				break;
			}
			break;
		case 3:
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
				if(game.getKeyManager().up && teamTargeted==true && !bs.bs.enemyTargets.isEmpty()){
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
				if(game.getKeyManager().down && teamTargeted==false && !bs.bs.alliesTargets.isEmpty()){
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
				if(game.getKeyManager().space){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(teamTargeted){
						targetedSchmuck = bs.bs.alliesTargets.get(currentlyTargeted);
					}
					else{
						targetedSchmuck = bs.bs.enemyTargets.get(currentlyTargeted);
					}
					phase++;
				}
	 			break;
	 		case 1:
				targetedSchmuck = currentSchmuck;
		 		phase++;
	 			break;
	 		case 2:
	 			if(game.getKeyManager().right){
	 				if(currentlyTargeted<allies.size()-1){
						currentlyTargeted++;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().left){
					if(currentlyTargeted>0){
						currentlyTargeted--;
											}	
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				if(game.getKeyManager().space){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					targetedSchmuck = allies.get(currentlyTargeted);
		 			phase++;
				}
	 			break;
	 		}
			break;
		case 4:
			//if menu is being called by waiting, the action is in index 0 and will occur instantly.
			if(bs.bp.pauseTOQ){
				TurnOrderQueue=0;
			}
			//otherwise, if in planing stage, move will be placed according to user's sorted space in the TOQ
			else{
				TurnOrderQueue=bs.bp.currentlySelected;
			}
			if(actionSelected == 3 && bs.bp.pauseTOQ){
				//if "Wait" is chosen, an extra pause at the beginning is given to prevent multiclicking as actions will be performed
				//instantly. Change this later when keylistener is updated
				try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}				
				bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new PassTurn(0),bs));
			}
			else{
				bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(currentSchmuck,targetedSchmuck,currentSkill,bs));
			}
			bs.bp.pauseTOQ=false;								//if dillydallying, end dillydally
			if(bs.bp.currentlySelected < bs.bs.alliesSelectable.size()-1){		//Immediately selects next unit to give command to
				bs.bp.currentlySelected++;						
			}
			else{
				bs.bp.currentlySelected = 0;
			}
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
			if(!temp.isEmpty()){
				bs.bp.bm = new BattleMenu(game,sm,allies,enemy,bs,bs.bs.alliesSelectable.get(bs.bp.currentlySelected),gs);

			}
			else{
				bs.bp.selected = false;	
			}			
			break;
		}
			
	}
			

	public void render(Graphics g) {
		//if exit is used by pressing x, actions will be de-selected. Eveything moves one menu screen back
		if(exit==true){
			switch(phase){
			case 1:
				if(bs.bp.phase==1){		//If used in planning phase, character is deselected. 
					bs.bp.selected=false;
				}
				break;
			case 2:
				phase--;
				itemSelected = 0;			
				itemPointer = 0;
				backpackLocation = 0;
				break;
			case 3:
				if(actionSelected != 0){
					phase--;
				}
				else{
					phase -=2;
				}
				break;
			}
			exit=false;
		}
		
		int menux = currentSchmuck.getX();
		int menuy = currentSchmuck.getY();
		
		if(phase == 1 || phase == 3){
			g.setColor(new Color(0, 0, 0, 200));
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
				g.drawImage(Assets.attack, menux + 8, menuy - 40, null);
				break;
			case 1:
				g.drawImage(Assets.skill, menux + 8, menuy - 8, null);
				break;
			case 2:
				g.drawImage(Assets.item, menux + 8, menuy + 24, null);
				break;
			case 3:
				if(bs.bp.pauseTOQ){
					g.drawImage(Assets.nothing, menux + 8, menuy + 56, null);
				}
				else{
					g.drawImage(Assets.wait, menux + 8, menuy + 56, null);
				}
				break;
			case 4:
				g.drawImage(Assets.run, menux + 8, menuy + 88, null);
				break;
			}
			
		}
		if(phase == 2 || phase == 3){
			switch(actionSelected){
			case 0:
				//If attack is chosen, nothing is displayed, skips right to targeting phase
				break;
			case 1:
				//if Skill is chosen, a list of skills covers up the actions menu
				g.setColor(Color.black);
				g.fillRect(menux, menuy - 40, 120, 160);
				ArrayList<Skills> skills = currentSchmuck.skills;
				g.setColor(new Color(255, 255, 51, 225));
				g.fillRect(menux , menuy - 65, 110, 25);
				g.fillRect(menux, menuy - 25 + 25 * itemPointer, 120, 25);
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(Color.white);
				g.drawString(currentSchmuck.getName(), menux, menuy - 50);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				if(skills.size()==0){
					g.drawString("Do Nothing", menux + 3, menuy - 10);
				}
				else{
					//Displays list of skill names and mp costs.
					skillnum = 0;                                                                                                                                                                                                                                                                                       
					for(int i = backpackLocation; i <= backpackLocation + 4 && i < currentSchmuck.skills.size(); i++){			
						g.setColor(Color.white);
						g.drawString(skills.get(i).getName()+"  "+(int)(skills.get(i).getCost()*(1+currentSchmuck.getMpCost()))+" Mp", menux + 3, menuy - 10 + 25 * (skillnum));
						skillnum++;
					}
					
					//Short descriptions are also visible at the bottom
					g.setColor(Color.white);
					g.fillRect(menux + 120, menuy - 35, 125, 75);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(Color.black);;
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
			case 2:	
				//Same as skills
				g.setColor(Color.black);
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
		
		if(phase == 3){
			pointed = currentSchmuck;
			switch(currentSkill.getTargetType()){
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
			case 2:
				pointed = allies.get(currentlyTargeted);
				break;
			}	
		}
	
		itemnum++;	
	}



}

