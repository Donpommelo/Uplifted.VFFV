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
				else{
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
				else {
					if(currentlyTargeted<allies.size()-1){
						currentlyTargeted++;
					}
					
				}
			}
			if(game.getKeyManager().up && teamTargeted==true){
				if(currentlyTargeted>=enemy.size()){
					currentlyTargeted=0;
				}
				else{
					currentlyTargeted=enemy.size()-1-currentlyTargeted;
				}
				teamTargeted=false;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			if(game.getKeyManager().down && teamTargeted==false){
				if(currentlyTargeted>=allies.size()){
					currentlyTargeted=0;
				}
				else{
					currentlyTargeted=allies.size()-currentlyTargeted-1;
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
							bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(allies.get(bs.bp.currentlySelected),enemy.get(currentlyTargeted),new StandardAttack(0),bs));
						}
						else{
							bs.bp.TurnOrderQueue.set(TurnOrderQueue,new Action(allies.get(bs.bp.currentlySelected),allies.get(currentlyTargeted),new StandardAttack(0),bs));
						}
						moveSelected=false;
						bs.bp.selected=false;
						bs.bp.pauseTOQ=false;
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
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),enemy.get(currentlyTargeted),new SkillNothing(1,gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(currentlyTargeted),new SkillNothing(1,gs),bs));

							}
						}
						else{
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),enemy.get(currentlyTargeted),skills.get(itemSelected),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(currentlyTargeted),skills.get(itemSelected),bs));
							}
						}
						moveSelected=false;
						bs.bp.selected=false;
						bs.bp.pauseTOQ=false;
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
					skillChosen=true;
//					moveSelected=false;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().up){
					if(itemSelected>0){
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
						itemSelected++;
						if(itemPointer==7){
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

						Set<Item> temp= gs.inventorymanager.backpack.keySet();
						Item[] itemDisplay= temp.toArray(new Item[999]);
						if(gs.inventorymanager.backpack.size()==0){
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),enemy.get(currentlyTargeted),new ItemNothing(1,gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(currentlyTargeted),new ItemNothing(1,gs),bs));

							}
						}
						else{
							if(teamTargeted==false){
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),enemy.get(currentlyTargeted),new UseItem(1,itemDisplay[itemSelected],gs),bs));
								
							}
							else{
								bs.bp.TurnOrderQueue.set(TurnOrderQueue, new Action(allies.get(bs.bp.currentlySelected),allies.get(currentlyTargeted),new UseItem(1,itemDisplay[itemSelected],gs),bs));
							}
						}
						moveSelected=false;
						bs.bp.selected=false;
						bs.bp.pauseTOQ=false;
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
//					moveSelected=false;									
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(game.getKeyManager().up){
					if(itemSelected>0){
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
						itemSelected++;
						if(itemPointer==7){
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
				break;
				
			case 4:
					actionSelected=0;
					playerSelected=false;
					moveSelected=false;
					sm.states.pop();
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
				g.fillRect(540, 291,100,125);
				g.setColor(new Color(255, 255,51));
				g.fillRect(540,291+25*actionSelected, 100, 25);
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(new Color(0, 0,0));
				g.drawString("Attack", 540, 310);
				g.drawString("Skills", 540, 335);
				g.drawString("Item", 540, 360);
				g.drawString("Wait", 540, 385);
				g.drawString("Run", 540, 410);

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
					for(int i=backpackLocation;i<=backpackLocation+26 && i<currentSchmuck.skills.size();i++){			
						g.setColor(new Color(0, 0,0));
						g.drawString(currentSchmuck.skills.get(i).getName()+"  "+currentSchmuck.skills.get(i).getCost()+" Bp", 505, 231+25*(skillnum));
						skillnum++;
					}	
				}
			if(backpackLocation!=0){
				g.drawImage(Assets.Uparrow,570,209,null);
			}
			if(backpackLocation!=currentSchmuck.skills.size()-8){
				g.drawImage(Assets.Downarrow,570,409,null);
			}				
				break;
			case 2:	
				g.setColor(new Color(102, 178,255));
				g.fillRect(500, 210, 140, 206);
				Set<Item> temp = gs.inventorymanager.backpack.keySet();
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
					for(int i=backpackLocation;i<=backpackLocation+26 && i<gs.inventorymanager.backpack.size();i++){			
						g.setColor(new Color(0, 0,0));
						g.drawString(itemDisplay[i].getName()+"  x"+gs.inventorymanager.backpack.get(itemDisplay[i]), 505, 231+25*(itemnum));
						itemnum++;
					}	
				}
			if(backpackLocation!=0){
				g.drawImage(Assets.Uparrow,570,209,null);
			}
			if(backpackLocation!=gs.inventorymanager.backpack.size()-8){
				g.drawImage(Assets.Downarrow,570,409,null);
			}
				
				break;
		}
		
			
		}
		if(itemChosen==true || attackChosen==true || skillChosen==true){
			if(teamTargeted){
				g.drawImage(Assets.Downarrow,98+currentlyTargeted*100,245,null);
			}
			else{
				g.drawImage(Assets.Downarrow,515-currentlyTargeted*150, 27,null);
			}
		}
	


		
	}



}
