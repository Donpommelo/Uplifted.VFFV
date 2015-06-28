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
					phase+=3;
					break;
				case 4:
					currentSkill = new Runaway(0);
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
						if(currentSchmuck.skills.get(itemSelected).getCost()>currentSchmuck.tempStats[1]){
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
						currentSkill = new UseItem(1,gs.inventorymanager.backpack.keySet().toArray(new Item[999])[itemSelected],gs);
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
				break;
			}
			break;
		case 3:
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
			if(bs.bp.currentlySelected < bs.bs.alliesTargets.size()-1){		//Immediately selects next unit to give command to
				bs.bp.currentlySelected++;						
			}
			else{
				bs.bp.currentlySelected = 0;
			}
			ArrayList<Schmuck> temp = new ArrayList<Schmuck>();
			for(Schmuck s : bs.bs.alliesTargets){
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
				bs.bp.bm = new BattleMenu(game,sm,allies,enemy,bs,bs.bs.alliesTargets.get(bs.bp.currentlySelected),gs);

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
		
		if(phase == 1 || phase == 3){
			g.setColor(new Color(102, 178,255));
			g.fillRect(540, 256,100,160);
			g.setColor(new Color(255, 255,51));
			g.fillRect(540,256+32*actionSelected, 100, 32);
			g.fillRect(530,233,110,23);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(new Color(0, 0,0));
			
			g.drawString(currentSchmuck.getName(),540, 250);
			
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
			
		}
		if(phase == 2 || phase == 3){
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
				if(currentSchmuck.skills.size()==0){
					g.drawString("Do Nothing", 505, 231);
				}
				else{
					
					//Displays list of skill names and mp costs
					skillnum=0;                                                                                                                                                                                                                                                                                       
					for(int i=backpackLocation;i<=backpackLocation+4 && i<currentSchmuck.skills.size();i++){			
						g.setColor(new Color(0, 0,0));
						g.drawString(currentSchmuck.skills.get(i).getName()+"  "+currentSchmuck.skills.get(i).getCost()+" Mp", 505, 231+25*(skillnum));
						skillnum++;
					}
					
					//Short descriptions are also visible at the bottom
					g.setColor(new Color(255, 255,255));
					g.fillRect(505, 340, 130, 76);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(new Color(0, 0,0));
					int y=340;
					for (String line : currentSchmuck.skills.get(itemSelected).getDescrShort().split("\n")){
						 g.drawString(line, 505, y += g.getFontMetrics().getHeight());
					}			       
				}
				if(backpackLocation!=0){
					g.drawImage(Assets.Uparrow,570,209,null);
				}
				if(backpackLocation!=currentSchmuck.skills.size()-5 && currentSchmuck.skills.size()>5){
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
		
		if(phase == 3){
			Schmuck pointed = currentSchmuck;
			switch(currentSkill.getTargetType()){
			case 0:
				if(teamTargeted){
					pointed = bs.bs.alliesTargets.get(currentlyTargeted);
				}
				else{
					pointed = bs.bs.enemyTargets.get(currentlyTargeted);
				} 
				break;
			case 2:
				pointed = allies.get(currentlyTargeted);
				break;
			}
			
			g.drawImage(pointer,pointed.getBattleSprite().getWidth()/2+pointed.getX()-16, pointed.getY()-10,null);
			
			g.setColor(new Color(102, 178,255));
			g.fillRect(520, 0,140,25);
			g.setFont(new Font("Chewy", Font.PLAIN, 16));
			g.setColor(new Color(0, 0,0));
			g.drawString(pointed.getName()+" ",520,20);
			
		}
	
	
		itemnum++;
		
	}



}

