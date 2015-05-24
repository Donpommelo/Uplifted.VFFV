package dev.zt.UpliftedVFFV.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;

//This is the menu state that is called up by pressing z during the game state.
//This displays info about party, inventory and everything else later.
public class MenuState extends State {
	
	private BufferedImage testImage;
	private GameState gamestate;
	private int optionSelected,characterSelected,itemSelected,itemPointer,backpackLocation, skillSelected;
	private int itemnum, itemOption, itemslot;
	private boolean optionChosen,characterChosen,itemChosen,exit;
	private boolean equipChosen,useitemChosen;
	StateManager statemanager;
	ArrayList<Character> party= new ArrayList<Character>();
	public MenuState(Game game, StateManager sm, GameState gs){
		super(game, sm);
		testImage = ImageLoader.loadImage("/textures/title.png");			//atm, this uses the title screen a a background.
		this.gamestate=gs;
		optionSelected=0;
		optionChosen=false;
		exit=false;
		characterSelected=0;
		itemSelected=0;
		itemPointer=0;
		backpackLocation=0;
		itemslot = 1;
	}

	public void tick() {
		
		//pressing exit will move back one screen or deselect stuff
		if(game.getKeyManager().x){
			exit=true;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//if you havent selected a subcategory yet, space, up and down will control that.
		if(optionChosen==false){
			if(game.getKeyManager().space){
				optionChosen=true;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(game.getKeyManager().up){
				if(optionSelected>0){
					optionSelected--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().down){
				if(optionSelected<3){			//4 options currently. change this number later wen more are added
					optionSelected++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		//if you've selected an option, the space to the right displays whatever you've selected
		else{
			switch(optionSelected){
			
			//The party option. This navigates through your current party with the left, right and space keys
			//This is used for viewing info about your party.
			//Eventually, selecting a character with space will bring up more information
			case 0: 
				if(characterChosen == false){
					if(game.getKeyManager().space){
						characterChosen=true;
						skillSelected = 0;
						itemSelected=0;
						itemPointer=0;
						backpackLocation=0;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(game.getKeyManager().right){
					if(characterSelected<gamestate.partymanager.party.size()-1){
						characterSelected++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							}
					}
					if(game.getKeyManager().left){
						if(characterSelected>0){
							characterSelected--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				else{
					if(game.getKeyManager().down){
						if(skillSelected<gamestate.partymanager.party.get(characterSelected).skills.size()-1){
							skillSelected++;
							if(itemPointer==3){
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
						if(game.getKeyManager().up){
							if(skillSelected>0){
								skillSelected--;
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
				}
				break;
				
			//Option 2 is inventory. This displays a 3*9 grid of your inventor and uses all directions to navigate.
			//Eventually, space will be used to select an item and use if possible.
			case 1:
				if(equipChosen){
					if(game.getKeyManager().space){
						Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
						Item[] itemDisplay= temp.toArray(new Item[27]);
						gamestate.partymanager.party.get(characterSelected).equip(itemDisplay[itemSelected],itemslot,gamestate.inventorymanager);
						exit = true;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(game.getKeyManager().right){
					if(characterSelected<gamestate.partymanager.party.size()-1){
						characterSelected++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							}
					}
					if(game.getKeyManager().left){
						if(characterSelected>0){
							characterSelected--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(game.getKeyManager().up){
						if(itemslot>1){
							itemslot--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(game.getKeyManager().down){
						if(itemslot<3){			
							itemslot++;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				else if(useitemChosen){
					if(game.getKeyManager().space){
						Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
						Item[] itemDisplay= temp.toArray(new Item[27]);
						itemDisplay[itemSelected].use(gamestate.partymanager.party.get(characterSelected));
						if(itemDisplay[itemSelected].consummable){
							gamestate.inventorymanager.use(itemDisplay[itemSelected]);
						}
						exit = true;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(game.getKeyManager().right){
					if(characterSelected<gamestate.partymanager.party.size()-1){
						characterSelected++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							}
					}
					if(game.getKeyManager().left){
						if(characterSelected>0){
							characterSelected--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
				else if(!itemChosen){
					if(game.getKeyManager().space){
						Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
						Item[] itemDisplay= temp.toArray(new Item[27]);
						if(!gamestate.inventorymanager.backpack.isEmpty()){
							itemChosen=true;
						}
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(game.getKeyManager().right){
						if(itemSelected<gamestate.inventorymanager.backpack.size()-1){
						itemSelected++;
						if(itemPointer==26){
							backpackLocation+=3;
							itemPointer=24;
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
					if(game.getKeyManager().left){
						if(itemSelected>0){
							itemSelected--;
						if(itemPointer==0){
							backpackLocation-=3;
							itemPointer=2;
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
						if(itemSelected<gamestate.inventorymanager.backpack.size()-3){
						itemSelected+=3;
						if(26-itemPointer<3){
							backpackLocation+=3;
						}
						else{
							itemPointer+=3;
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							}
					}
					if(game.getKeyManager().up){
						if(itemSelected>2){
							itemSelected-=3;
						if(itemPointer<3){
							backpackLocation-=3;
						}
						else{
							itemPointer-=3;
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
				else{
					if(game.getKeyManager().right){
					if(itemOption<2){
						itemOption++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
							}
					}
					if(game.getKeyManager().left){
						if(itemOption>0){
							itemOption--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(game.getKeyManager().space){
						itemChosen = false;
						Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
						Item[] itemDisplay= temp.toArray(new Item[27]);
						switch(itemOption){
						case 0:
							if(itemDisplay[itemSelected].usedfromMenu){
								if(itemDisplay[itemSelected].targeted){
									useitemChosen = true;
								}
								else{
									itemDisplay[itemSelected].use(null,null);
								}
							}
							break;
						case 1:
							if(itemDisplay[itemSelected].equipable){
								equipChosen = true;
							}
							break;
						case 2:
							exit = true;		
							itemChosen = true;
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
				
		}
	
		
	}


	public void render(Graphics g) {
		
		//if x is pressed, the menu will go back one screen
		if(exit==true){
			if(equipChosen || useitemChosen){
				equipChosen=false;
				useitemChosen=false;
			}
			else if(characterChosen==true){
				characterChosen=false;
			}
			else if(itemChosen==true){
				itemChosen=false;
			}
			else if(optionChosen==true){
				optionChosen=false;
			}
			else{
				statemanager.states.pop();
			}
			exit=false;
		}
		
		//ackground consists of black with an image in front. Def change this later
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(testImage, 48, 0, null);
		
		//Color of sidebar chnages depending on whether it is selected or not
		if(optionChosen==true){
			g.setColor(new Color(160,160,160));
		}
		else{
			g.setColor(new Color(255, 255,51));
		}
		g.fillRect(5, 5,125,406);
		g.setColor(new Color(102, 178,255));
		g.fillRect(5,5+25*optionSelected, 125, 25);
		g.setFont(new Font("Chewy", Font.PLAIN, 18));
		g.setColor(new Color(0, 0,0));
		g.drawString("Party", 10, 25);
		g.drawString("Inventory", 10, 50);
		g.drawString("Map", 10, 75);
		g.drawString("Directory", 10, 100);
		g.drawString(gamestate.Script+" Script", 10, 400);
			switch(optionSelected){
			case 0:
				if(optionChosen==false){
					g.setColor(new Color(160, 160,160));
				}
				else{
					g.setColor(new Color(255, 255,51));
				}
				g.fillRect(135, 5,500,160);
				g.fillRect(135, 170, 500, 241);
				for(int i=0;i<gamestate.partymanager.party.size();i++){
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(new Color(0, 0,0));
				g.drawString(gamestate.partymanager.party.get(i).getName(), 150+100*i, 30);
				g.drawImage(gamestate.partymanager.party.get(i).getMenuSprite(),130+100*i,15,100,150,null);
				}
				g.drawImage(Assets.Downarrow,180+characterSelected*100,5,null);
				g.setColor(new Color(102, 178,255));
				g.fillRect(140, 175, 150, 225);
				Schmuck tempSchmuck=gamestate.partymanager.party.get(characterSelected);
				g.drawImage(tempSchmuck.getMenuSprite(), 140, 175,150,225, null);
				g.setColor(new Color(0, 0,0));
				g.drawString(tempSchmuck.getName()+" Lvl "+tempSchmuck.getLvl(),300,190);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				g.drawString((int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)+"/"+(int)(Math.pow(tempSchmuck.Lvl,2)*10)+" Exp",575,190);
				g.setColor(new Color(102, 178,255));
				g.fillRect(410, 180, 160, 5);
				g.setColor(new Color(0,204,0));
				g.fillRect(410, 180, 160*(int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)/(int)(Math.pow(tempSchmuck.Lvl,2)*10), 5);
				g.setColor(new Color(0, 0,0));
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.drawString("Hp: "+tempSchmuck.getCurrentHp()+"/"+tempSchmuck.getMaxHp(),300,215);
				g.drawString("Bp: "+tempSchmuck.getCurrentBp()+"/"+tempSchmuck.getMaxBp(),300,240);
				g.drawString("Pow: "+tempSchmuck.getBuffedPow()+"("+tempSchmuck.getBasePow()+")",300,265);
				g.drawString("Def: "+tempSchmuck.getBuffedDef()+"("+tempSchmuck.getBaseDef()+")",300,290);
				g.drawString("Spd: "+tempSchmuck.getBuffedSpd()+"("+tempSchmuck.getBaseSpd()+")",300,315);
				g.drawString("Skl: "+tempSchmuck.getBuffedSkl()+"("+tempSchmuck.getBaseSkl()+")",300,340);
				g.drawString("Int: "+tempSchmuck.getBuffedInt()+"("+tempSchmuck.getBaseInt()+")",300,365);
				g.drawString("Luk: "+tempSchmuck.getBuffedLuk()+"("+tempSchmuck.getBaseLuk()+")",300,390);
				g.drawString("Equiptment", 400,215);
				if(tempSchmuck.itemSlot1 == null){
					g.drawString("Item slot 1: Nothing", 400,240);
				}
				else{
					g.drawString("Item slot 1: "+tempSchmuck.itemSlot1.getName(),400,240);
				}
				if(tempSchmuck.itemSlot2 == null){
					g.drawString("Item slot 2: Nothing", 400,265);
				}
				else{
					g.drawString("Item slot 2: "+tempSchmuck.itemSlot2.getName(),400,265);
				}
				if(tempSchmuck.itemSlot3 == null){
					g.drawString("Item slot 3: Nothing", 400,290);
				}
				else{
					g.drawString("Item slot 3: "+tempSchmuck.itemSlot3.getName(),400,290);
				}
				
				if(characterChosen==true){
					g.setColor(new Color(255, 255,51));
					g.fillRect(135, 5,500,406);
					g.setColor(new Color(102, 178,255));
					g.fillRect(140, 10, 150, 225);
					g.drawImage(tempSchmuck.getMenuSprite(), 140, 10,150,225, null);
					g.setColor(new Color(0, 0,0));
					g.setFont(new Font("Chewy", Font.PLAIN, 18));
					g.drawString(tempSchmuck.getName()+" Lvl "+tempSchmuck.getLvl(),140,25);
					g.setColor(new Color(102, 178,255));
					g.fillRect(140, 240,250,166);
					g.fillRect(395, 240,235,166);
					g.setColor(new Color(0, 0,0));
					g.drawString("Abilities:", 240, 255);
					int skillnum=0;                                                                                                                                                                                                                                                                                       
					for(int i=backpackLocation;i<=backpackLocation+3 && i<tempSchmuck.skills.size();i++){			
						g.drawString(tempSchmuck.skills.get(i).getName()+"  "+tempSchmuck.skills.get(i).getCost()+" Bp", 142,275+35*skillnum);

						skillnum++;
					}	
					for(int i=0; i<4 && i<tempSchmuck.skills.size();i++){	
						g.drawImage(tempSchmuck.skills.get(backpackLocation+i).getIcon(), 355, 260+32*i, null);
					}
					g.drawImage(Assets.Downarrow,142,258+32*itemPointer,null);
					if(backpackLocation!=0){
						g.drawImage(Assets.Uparrow,200,245,null);
					}
					if(backpackLocation!=tempSchmuck.skills.size()-4 && tempSchmuck.skills.size()>4){
						g.drawImage(Assets.Downarrow,200,405,null);
					}
					if(!tempSchmuck.skills.get(skillSelected).getDescr().equals("meep")){
						int y=245;
						for (String line : tempSchmuck.skills.get(skillSelected).getDescr().split("\n"))
					        g.drawString(line, 400, y += g.getFontMetrics().getHeight());
					}
				}
				
				break;
			case 1:
				if(optionChosen==false){
					g.setColor(new Color(160, 160,160));
				}
				else{
					g.setColor(new Color(255, 255,51));
				}
				g.fillRect(135, 5,500,160);
				g.fillRect(135, 170, 500, 240);
				Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
				Item[] itemDisplay= temp.toArray(new Item[27]);
				if(itemDisplay[itemSelected]!=null){
				g.setColor(new Color(102, 178,255));
				g.fillRect(136+166*(itemPointer%3), 180+25*(itemPointer/3), 166, 25);
				}
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				itemnum=0;                                                                                                                                                                                                                                                                                       
//				for(Item current : temp){
				for(int i=backpackLocation;i<=backpackLocation+26 && i<gamestate.inventorymanager.backpack.size();i++){			
					g.setColor(new Color(0, 0,0));
					g.drawString(itemDisplay[i].getName()+"  x"+gamestate.inventorymanager.backpack.get(itemDisplay[i]), 140+175*(itemnum%3), 200+25*(itemnum/3));
					itemnum++;
				}

				if(itemDisplay[itemSelected]!=null){
					g.setColor(new Color(255, 255,255));
					g.fillRect(140, 10, 150, 150);
					g.setFont(new Font("Chewy", Font.PLAIN, 18));
					g.setColor(new Color(0, 0,0));
					g.drawString(itemDisplay[itemSelected].getName(),295,30);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					if(itemDisplay[itemSelected].getDescr()!=null){
//						g.drawString(itemDisplay[itemSelected].getDescr(), 295, 60);
						int y=60;
						for (String line : itemDisplay[itemSelected].getDescr().split("\n"))
					        g.drawString(line, 295, y += g.getFontMetrics().getHeight());
					}
				}
				else if(temp.size() == 0){
					g.setColor(new Color(0, 0,0));
					g.setFont(new Font("Chewy", Font.PLAIN, 50));
					g.drawString("Your Inventory is Empty", 145, 115);
					g.setFont(new Font("Chewy", Font.PLAIN, 130));
					g.drawString("Get a Job", 150, 320);
				}
				
				if(backpackLocation>2){
					g.drawImage(Assets.Uparrow,385,165,null);
				}
				if((backpackLocation+27)/3!=(gamestate.inventorymanager.backpack.size()+2)/3){
					if(gamestate.inventorymanager.backpack.size()!=0){
						g.drawImage(Assets.Downarrow,385,405,null);
					}
				}
				if(itemChosen==true){
					if(itemDisplay[itemSelected] != null){
						g.setColor(new Color(102, 178,255));
						g.fillRect(300, 125,100,35);
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 18));
						g.drawString("Use", 330, 150);
					
						g.setColor(new Color(102, 178,255));
						g.fillRect(405, 125,100,35);
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 18));
						g.drawString("Equip", 425, 150);
						
						g.setColor(new Color(102, 178,255));
						g.fillRect(510, 125,100,35);
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 18));
						g.drawString("Exit", 540, 150);
						
						g.drawImage(Assets.Downarrow,330+105*itemOption,120,null);
					}
										
				}
				if(equipChosen || useitemChosen){
					g.setColor(new Color(102, 178,255));
					g.fillRect(135, 5,500,160);
					tempSchmuck = gamestate.partymanager.party.get(characterSelected);
					for(int i=0;i<gamestate.partymanager.party.size();i++){
						g.setFont(new Font("Chewy", Font.PLAIN, 18));
						g.setColor(new Color(0, 0,0));
						g.drawString(gamestate.partymanager.party.get(i).getName(), 150+100*i, 30);
						g.drawImage(gamestate.partymanager.party.get(i).getMenuSprite(),130+100*i,15,100,150,null);
					}
					g.setColor(new Color(102, 178,255));
					g.fillRect(135, 170, 500, 240);
					g.setFont(new Font("Chewy", Font.PLAIN, 18));
					g.drawImage(tempSchmuck.getMenuSprite(), 140, 175,150,225, null);
					g.setColor(new Color(0, 0,0));
					g.drawString(tempSchmuck.getName()+" Lvl "+tempSchmuck.getLvl(),300,190);
					g.setFont(new Font("Chewy", Font.PLAIN, 12));
					g.setColor(new Color(102, 178,255));
					g.fillRect(410, 180, 160, 5);
					g.setColor(new Color(0,204,0));
					g.fillRect(410, 180, 160*(int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)/(int)(Math.pow(tempSchmuck.Lvl,2)*10), 5);
					g.drawImage(Assets.Downarrow,180+characterSelected*100,5,null);
					if(equipChosen){
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 18));
						g.drawString("Equiptment", 300,215);
						if(tempSchmuck.itemSlot1 == null){
							g.drawString("Item slot 1: Nothing", 300,240);
						}
						else{
							g.drawString("Item slot 1: "+tempSchmuck.itemSlot1.getName(),300,240);
						}
						if(tempSchmuck.itemSlot2 == null){
							g.drawString("Item slot 2: Nothing", 300,290);
						}
						else{
							g.drawString("Item slot 2: "+tempSchmuck.itemSlot2.getName(),300,290);
						}
						if(tempSchmuck.itemSlot3 == null){
							g.drawString("Item slot 3: Nothing", 300,340);
						}
						else{
							g.drawString("Item slot 3: "+tempSchmuck.itemSlot3.getName(),300,340);
						}									
						g.drawString(itemDisplay[itemSelected].name,500,190+50*itemslot);
					}
					if(useitemChosen){
						g.setColor(new Color(102, 178,255));
						g.fillRect(140, 175, 150, 225);
						g.drawImage(tempSchmuck.getMenuSprite(), 140, 175,150,225, null);
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 12));
						g.drawString((int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)+"/"+(int)(Math.pow(tempSchmuck.Lvl,2)*10)+" Exp",575,190);
						g.setColor(new Color(102, 178,255));
						g.fillRect(410, 180, 160, 5);
						g.setColor(new Color(0,204,0));
						g.fillRect(410, 180, 160*(int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)/(int)(Math.pow(tempSchmuck.Lvl,2)*10), 5);
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 18));
						g.drawString("Hp: "+tempSchmuck.getCurrentHp()+"/"+tempSchmuck.getMaxHp(),300,215);
						g.drawString("Bp: "+tempSchmuck.getCurrentBp()+"/"+tempSchmuck.getMaxBp(),300,240);
						g.drawString("Pow: "+tempSchmuck.getBuffedPow()+"("+tempSchmuck.getBasePow()+")",300,265);
						g.drawString("Def: "+tempSchmuck.getBuffedDef()+"("+tempSchmuck.getBaseDef()+")",300,290);
						g.drawString("Spd: "+tempSchmuck.getBuffedSpd()+"("+tempSchmuck.getBaseSpd()+")",300,315);
						g.drawString("Skl: "+tempSchmuck.getBuffedSkl()+"("+tempSchmuck.getBaseSkl()+")",300,340);
						g.drawString("Int: "+tempSchmuck.getBuffedInt()+"("+tempSchmuck.getBaseInt()+")",300,365);
						g.drawString("Luk: "+tempSchmuck.getBuffedLuk()+"("+tempSchmuck.getBaseLuk()+")",300,390);
					}
					
				}
			}


		
//		g.drawImage(testImage, 0, 0, null);
//		if(optionChosen){
//			statemanager.states.pop();
//			optionChosen=false;
//			StateManager.states.push(new DialogState(game,statemanager,0,2));
//		}
		
	}

	@Override
	public void init() {
		
	}
	

}
