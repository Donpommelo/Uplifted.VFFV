package dev.zt.UpliftedVFFV.Battle;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.DillyDally;
import dev.zt.UpliftedVFFV.ablities.ItemNothing;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Runaway;
import dev.zt.UpliftedVFFV.ablities.SkillNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.ablities.UseItem;
import dev.zt.UpliftedVFFV.dialog.Dialog;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.utils.Utils;


public class BattleMenu{
	
	public int currentlySelected;
	public int currentlyTargeted;
	public int actionSelected;
	public int skillSelected;
	public int itemSelected;
	public int itemPointer;
	public int backpackLocation;
	public int itemnum;
	public int skillnum;
	public int TurnOrderQueue;
	public StateManager sm;
	public Game game;
	public Boolean exit = false;
	public Boolean playerSelected = false;	
	public Boolean moveSelected = false;
	public Boolean itemChosen = false;
	public Boolean attackChosen = false;
	public Boolean skillChosen = false;
	public Boolean teamTargeted = false;
	public BufferedImage pointer = Assets.pointer;
	public ArrayList<Schmuck>allies=new ArrayList<Schmuck>();
	public ArrayList<Schmuck> enemy=new ArrayList<Schmuck>();
	public Schmuck currentSchmuck;
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
		
		if(itemChosen==true || attackChosen==true || skillChosen==true){
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
		}
		if(moveSelected==true){
			if(bs.bp.pauseTOQ){
				TurnOrderQueue=0;
			}
			else{
				TurnOrderQueue=bs.bp.currentlySelected;
			}
			switch(actionSelected){
			case 0:	
				if(attackChosen==true){
					if(game.getKeyManager().space){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if(teamTargeted==false){
							bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new StandardAttack(0),bs));
						}
						else{
							bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new StandardAttack(0),bs));
						}
						moveSelected=false;
						bs.bp.selected=false;
						bs.bp.pauseTOQ=false;
						if(bs.bp.currentlySelected < allies.size()-1){
							bs.bp.currentlySelected++;
						}
						else{
							bs.bp.currentlySelected = 0;
						}
					}
				}
				
				
				break;
			case 1:
				if(skillChosen==true){
					if(game.getKeyManager().space){
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						ArrayList<Skills> skills = currentSchmuck.skills;
						if(currentSchmuck.skills.size()==0){
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new SkillNothing(1,gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new SkillNothing(1,gs),bs));

							}
						}
						else{
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),skills.get(itemSelected),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),skills.get(itemSelected),bs));
							}
						}
						moveSelected=false;
						bs.bp.selected=false;
						bs.bp.pauseTOQ=false;
						if(bs.bp.currentlySelected < allies.size()-1){
							bs.bp.currentlySelected++;
						}
						else{
							bs.bp.currentlySelected = 0;
						}
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
					if(currentSchmuck.skills.get(itemSelected).getCost()>currentSchmuck.tempStats[1]){
						bs.bp.bt.textList.add(currentSchmuck.getName()+" doesn't have the Motivation Points to do that.");
					}
					else{
						skillChosen=true;
						if(!currentSchmuck.skills.isEmpty()){
							teamTargeted =  currentSchmuck.skills.get(itemSelected).startTarget(); // do to other stuff
						}
//						moveSelected=false;
					}
					
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
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.enemyTargets.get(currentlyTargeted),new ItemNothing(1,gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),bs.bs.alliesTargets.get(currentlyTargeted),new ItemNothing(1,gs),bs));

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
						bs.bp.selected=false;
						bs.bp.pauseTOQ=false;
						if(bs.bp.currentlySelected < allies.size()-1){
							bs.bp.currentlySelected++;
						}
						else{
							bs.bp.currentlySelected = 0;
						}
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
					teamTargeted =  new UseItem(1,gs.inventorymanager.backpack.keySet().toArray(new Item[999])[itemSelected],gs).startTarget();
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
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(bs.bp.pauseTOQ){
//						System.out.print("meep");
						bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new PassTurn(0),bs));
					}
					else{
						bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new DillyDally(0),bs));
					}
					moveSelected=false;
					bs.bp.selected=false;		
					bs.bp.pauseTOQ=false;
					if(bs.bp.currentlySelected < allies.size()-1){
						bs.bp.currentlySelected++;
					}
					else{
						bs.bp.currentlySelected = 0;
					}
				break;
				
			case 4:
				bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(bs.bp.currentlySelected),new Runaway(0),bs));
				moveSelected=false;
				bs.bp.selected=false;		
				bs.bp.pauseTOQ=false;
				if(bs.bp.currentlySelected < allies.size()-1){
					bs.bp.currentlySelected++;
				}
				else{
					bs.bp.currentlySelected = 0;
				}
				break;
			
			}
		}
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
			if(game.getKeyManager().space){
				moveSelected=true;

				switch(actionSelected){
				case 0:
					attackChosen=true;
					break;
				case 1:
	//				skillChosen=true;
					break;
				case 2:
	//				itemChosen=true;
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
		if(exit==true){
			currentlyTargeted = 0;

			if(attackChosen==true){
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

			
			
			else if(bs.bp.phase==1){
					bs.bp.selected=false;
				
			}
			exit=false;
		}
		if(moveSelected){
//			g.drawImage(Assets.Downarrow,515-currentlyTargeted*150,-3,null);
			}
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

		if(moveSelected){
			switch(actionSelected){
			case 0:
				
				break;
			case 1:
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
					skillnum=0;                                                                                                                                                                                                                                                                                       
					for(int i=backpackLocation;i<=backpackLocation+4 && i<currentSchmuck.skills.size();i++){			
						g.setColor(new Color(0, 0,0));
						g.drawString(currentSchmuck.skills.get(i).getName()+"  "+currentSchmuck.skills.get(i).getCost()+" Bp", 505, 231+25*(skillnum));
						skillnum++;
					}
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
		}
		
			
		}
		if(itemChosen==true || attackChosen==true || skillChosen==true){
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
			
			itemnum++;
		}
	
		

		
	}



}
