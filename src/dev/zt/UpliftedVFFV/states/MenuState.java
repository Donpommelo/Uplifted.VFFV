package dev.zt.UpliftedVFFV.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.utils.Utils;

//This is the menu state that is called up by pressing z during the game state.
//This displays info about party, inventory and everything else later.
public class MenuState extends State {
	
	private BufferedImage testImage, window, window2;
	private GameState gamestate;
	private int optionSelected,characterSelected,itemSelected,itemPointer,backpackLocation, skillSelected, skillPointer,skillLocation;
	private int itemnum, itemOption, itemslot;
	private boolean optionChosen,characterChosen,itemChosen,exit;
	private boolean equipChosen,useitemChosen;
	StateManager statemanager;
	ArrayList<Character> party= new ArrayList<Character>();
	public MenuState(Game game, StateManager sm, GameState gs){
		super(game, sm);
		testImage = ImageLoader.loadImage("/textures/title.png");			//atm, this uses the title screen a a background.
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		window2 = ImageLoader.loadImage("/ui/Window/WindowWhite.png");
		this.gamestate=gs;
		optionSelected=0;
		optionChosen=false;
		exit=false;
		characterSelected=0;
		itemSelected=0;
		itemPointer=0;
		backpackLocation=0;
		skillSelected=0;
		skillPointer=0;
		skillLocation=0;
		itemslot = 0;
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
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
					optionSelected--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().down){
				if(optionSelected<5){			//4 options currently. change this number later wen more are added
					game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
						skillPointer=0;
						skillLocation=0;
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(game.getKeyManager().right){
					if(characterSelected<gamestate.partymanager.party.size()-1){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
							skillSelected++;
							if(skillPointer==3){
								skillLocation++;
							}
							else{
								skillPointer++;
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
								game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
								skillSelected--;
								if(skillPointer==0){
									skillLocation--;
								}
								else{
									skillPointer--;
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
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
							characterSelected--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(game.getKeyManager().up){
						if(itemslot>0){
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemslot--;
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					if(game.getKeyManager().down){
						if(itemslot<gamestate.partymanager.party.get(characterSelected).getItemSlots()-1){			
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
						if(itemDisplay[itemSelected].isConsummable()){
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
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
//						Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
//						Item[] itemDisplay= temp.toArray(new Item[27]);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
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
							if(itemDisplay[itemSelected].isUsedfromMenu()){
								if(itemDisplay[itemSelected].targeted){
									useitemChosen = true;
								}
								else{
									itemDisplay[itemSelected].use();
								}
							}
							break;
						case 1:
							if(itemDisplay[itemSelected].getSlot() == 1){
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
				StateManager.getStates().pop();
			}
			exit=false;
		}
		
		//background consists of black with an image in front. Def change this later
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(testImage, 48, 0, null);
		
		String[] options = {"Party", "Inventory", "Map", "Directory", "Objectives", "Quit"};
		Utils.drawMenu(g, window, options, Color.black, 25, optionSelected, 5, 5, 125, 380, !optionChosen, true);
		g.drawString(gamestate.Script + " Script", 25, 375);
		
		switch(optionSelected){
			//Character view screen.
			case 0:
			
			//Manually draw party names and portraits.
			Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 5, 480, 150, optionChosen);
			//Draw custom Cursor.
			Utils.drawCursor(g, window, 138 + characterSelected * 100, 14, 100, 128, false);
			for(int i = 0; i < gamestate.partymanager.party.size(); i++){
				g.drawString(gamestate.partymanager.party.get(i).getName(), 160 + 100 * i, 30);
				g.drawImage(gamestate.partymanager.party.get(i).getMenuSprite(), 144 + 100 * i, 15, 94, 141, null);
			}
			
			//Draw character stats.
			Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 170, 480, 225, optionChosen);
			Schmuck tempSchmuck=gamestate.partymanager.party.get(characterSelected);
			g.setColor(Color.white);
			g.fillRect(148, 182, 142, 218);
			g.drawImage(tempSchmuck.getMenuSprite(), 140, 175, 150, 225, null);
			g.setColor(Color.black);
			g.setFont(new Font("Chewy", Font.PLAIN, 12));
			g.drawString(tempSchmuck.getName() +" Lvl "+tempSchmuck.getLvl(), 338, 194);
			g.drawString((int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)+"/"+(int)(Math.pow(tempSchmuck.Lvl,2)*10)+" Exp", 575, 194);
			g.setColor(Color.darkGray);
			g.fillRect(408, 188, 160, 5);
			g.setColor(Color.green);
			g.fillRect(408, 188, 160*(int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)/(int)(Math.pow(tempSchmuck.Lvl,2)*10), 5);
			g.setColor(Color.black);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.drawString("Hp: ", 300, 220);
			g.drawString("Bp: ", 300, 245);
			g.drawString("Pow: ", 300, 270);
			g.drawString("Def: ", 300, 295);
			g.drawString("Spd: ", 300, 320);
			g.drawString("Skl: ", 300, 345);
			g.drawString("Int: ", 300, 370);
			g.drawString("Luk: ", 300, 395);
			
			//Draw stat values.
			FontMetrics metrics = g.getFontMetrics(new Font("Chewy", Font.PLAIN, 18));
			for(int i = 0; i < tempSchmuck.baseStats.length; i++){
				if(i <= 1){
					if(i == 0){
						g.drawString(tempSchmuck.getCurrentHp() + "/" + tempSchmuck.getBaseHp(), 340, 220);
					}
					else{
						g.drawString(tempSchmuck.getCurrentBp() + "/" + tempSchmuck.getBaseBp(), 340, 220 + 25);
					}
					if(tempSchmuck.buffedStats[i] != tempSchmuck.baseStats[i]){
						if(tempSchmuck.buffedStats[i] > tempSchmuck.baseStats[i]){
							g.setColor(Color.green);
						} else if (tempSchmuck.buffedStats[i] < tempSchmuck.baseStats[i]){
							g.setColor(Color.red);
						}
						if(i == 0){
							g.drawString("(" + tempSchmuck.getMaxHp() + ")", 345 + metrics.stringWidth(tempSchmuck.getCurrentHp() + "/" + tempSchmuck.getBaseHp()), 220 + 25 * i);
						}
						else{
							g.drawString("(" + tempSchmuck.getMaxBp() + ")", 345 + metrics.stringWidth(tempSchmuck.getCurrentBp() + "/" + tempSchmuck.getBaseBp()), 220 + 25 * i);
						}
					}
				} else{
					g.drawString(tempSchmuck.baseStats[i] + "", 340, 220 + 25 * i);
					if(tempSchmuck.buffedStats[i] != tempSchmuck.baseStats[i]){
						if(tempSchmuck.buffedStats[i] > tempSchmuck.baseStats[i]){
							g.setColor(Color.green);
						} else if (tempSchmuck.buffedStats[i] < tempSchmuck.baseStats[i]){
							g.setColor(Color.red);
						}
						g.drawString("(" + tempSchmuck.buffedStats[i] + ")", 345 + metrics.stringWidth(tempSchmuck.baseStats[i] + ""), 220 + 25 * i);
					}
				}
				g.setColor(Color.black);
			}
			
			//Alignment.
			g.setFont(new Font("Chewy", Font.PLAIN, 12));
			g.fillRect(308, 184, 16, 16);
			switch((int)tempSchmuck.getElemAlignment()){
				case 0:
					g.setColor(Color.white);
					break;
				case 1:
					g.setColor(Color.red);
					break;
				case 2:
					g.setColor(Color.blue);
					break;	
				case 3:
					g.setColor(Color.green);
					break;	
				case 4:
					g.setColor(Color.yellow);
					break;
				case 5:
					g.setColor(Color.magenta);
					break;
				case 6:
					g.setColor(Color.black);
					break;
			}
			g.fillRect(309, 185, 14, 14);
			
			//Draw equipped items.
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(Color.black);
			g.drawString("Equipment", 455, 235);
			for(int i = 0; i < tempSchmuck.getItemSlots(); i++){
				if(tempSchmuck.getItems()[i] == null){
					g.setColor(Color.black);
					g.drawString("Nothing", 500, 260 + 40 * i);
					g.fillRect(450, 240 + i * 40, 36, 36);
				}
				else{
					g.setColor(Color.black);
					g.drawString(tempSchmuck.getItems()[i].getName(), 500, 260 + 40 * i);
					g.fillRect(450, 240 + i * 40, 36, 36);
					g.setColor(Color.white);
					g.fillRect(452, 242 + i * 40, 32, 32);
				}
			}
			
			//2nd level of character info tab.
			if(characterChosen==true){
//				g.setColor(new Color(255, 255,51));
//				g.fillRect(135, 5,500,406);
				Utils.drawDialogueBox(g, window, "", 18, Color.black, 132, 5, 496, 384, characterChosen);
				g.setColor(Color.white);
				g.fillRect(145, 20, 150, 200);
				g.drawImage(tempSchmuck.getMenuSprite(), 140, 10, 135, 201, null);
				g.setColor(Color.black);
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.drawString(tempSchmuck.getName() + " Lvl " + tempSchmuck.getLvl(), 145, 30);
				
				//Draw tabs.
				g.setColor(Color.lightGray);
				g.fillRect(140, 212, 250, 28);
				g.setColor(Color.white);
				for(int i = 0; i < 5; i++){
					g.fillRect(142 + 50 * i, 214, 46, 24);
				}
				g.setColor(Color.black);
				g.drawString("Skills", 145, 232);
				
				//Draw scrolling display options and icons
				int skillnum = 0;                                                                                                                                                                                                                                                                                       
				Utils.drawDialogueBox(g, window2, "", 18, Color.black, 140, 240, 250, 150, characterChosen);
				for(int i=skillLocation;i<=skillLocation+3 && i<tempSchmuck.skills.size();i++){			
					g.drawString(tempSchmuck.skills.get(i).getName() + "  " +
							(int)(tempSchmuck.skills.get(i).getCost() * (1+tempSchmuck.getMpCost())) + " Mp", 
							150, 274 + 36 * skillnum);

					skillnum++;
				}	
				for(int i = 0; i < 4 && i < tempSchmuck.skills.size(); i++){	
					g.drawImage(tempSchmuck.skills.get(skillLocation+i).getIcon(), 355, 254 + 36 * i, null);
				}
				//Draw custom cursor.
				Utils.drawCursor(g, window2, 140, 245 + 36 * skillPointer, 250, 32, characterChosen);
				if(skillLocation!=0){
					g.drawImage(Assets.Uparrow, 265 - Assets.Uparrow.getWidth() / 2, 225, null);
				}
				if(skillLocation!=tempSchmuck.skills.size()-4 && tempSchmuck.skills.size()>4){
					g.drawImage(Assets.Downarrow, 265 - Assets.Uparrow.getWidth() / 2, 390, null);
				}
				
				//Draw info box.
				Utils.drawDialogueBox(g, window2, "", 18, Color.black, 398, 240, 235, 150, characterChosen);
				if(!tempSchmuck.skills.get(skillSelected).getDescr().equals("meep")){
					int y = 245;
					for (String line : tempSchmuck.skills.get(skillSelected).getDescr().split("\n"))
				        g.drawString(line, 410, y += g.getFontMetrics().getHeight());
				}
				
				//Draw Alignment bars.
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.setColor(Color.black);
				for(int i = 0; i < 6; i++){
					g.fillRect(325, 30 + 25 * i, 16, 16);
				}
				int alignment = (int)tempSchmuck.getElemAlignment() - 1;
				if(alignment >= 0){
					g.drawRect(324, 29 + 25 * alignment, 17, 17);
				} else{
					g.drawRect(324, 154, 17, 17);
				}
				
				int remaining = (tempSchmuck.getPrismaticPoints() - tempSchmuck.getElemPoints()[4] 
						- tempSchmuck.getElemPoints()[3] - tempSchmuck.getElemPoints()[2] - tempSchmuck.getElemPoints()[1]
						- tempSchmuck.getElemPoints()[0]);
				g.setColor(Color.red);				
				g.fillRect(326, 31, 14, 14);
				g.fillRect(345, 32, tempSchmuck.getElemPoints()[0] * 3, 12);
				g.drawString(tempSchmuck.getElemPoints()[0] + "", 575, 45);
				g.setColor(Color.blue);
				g.fillRect(326, 56, 14, 14);
				g.fillRect(345, 57, tempSchmuck.getElemPoints()[1] * 3, 12);
				g.drawString(tempSchmuck.getElemPoints()[1] + "", 575, 70);
				g.setColor(Color.green);
				g.fillRect(326, 81, 14, 14);
				g.fillRect(345, 82, tempSchmuck.getElemPoints()[2] * 3, 12);
				g.drawString(tempSchmuck.getElemPoints()[2] + "", 575, 95);
				g.setColor(Color.yellow);
				g.fillRect(326, 106, 14, 14);
				g.fillRect(345, 107, tempSchmuck.getElemPoints()[3] * 3, 12);
				g.drawString(tempSchmuck.getElemPoints()[3] + "", 575, 120);
				g.setColor(Color.magenta);
				g.fillRect(326, 131, 14, 14);
				g.fillRect(345, 132, tempSchmuck.getElemPoints()[4] * 3, 12);
				g.drawString(tempSchmuck.getElemPoints()[4] + "", 575, 145);
				g.setColor(Color.white);
				g.fillRect(326, 156, 14, 14);
				g.fillRect(345, 157,  remaining * 3 , 12);
				g.drawString(remaining + "", 575, 170);
			}
			break;
			
			//Draw inventory.
			case 1:
				Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 5, 480, 150, optionChosen);
				Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 170, 480, 225, optionChosen);
				Set<Item> temp= gamestate.inventorymanager.backpack.keySet();
				Item[] itemDisplay= temp.toArray(new Item[27]);
				//Draw cursor.
				if(itemDisplay[itemSelected]!=null){
//					g.setColor(new Color(102, 178,255));
//					g.fillRect(136+166*(itemPointer%3), 180+25*(itemPointer/3), 166, 25);
					Utils.drawCursor(g, window, 136 + 166 * (itemPointer%3), 180 + 25 * (itemPointer / 3), 160, 16, optionChosen);
				}
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				itemnum=0;                                                                                                                                                                                                                                                                                       
				for(int i=backpackLocation;i<=backpackLocation+26 && i<gamestate.inventorymanager.backpack.size();i++){			
					g.setColor(Color.black);
					g.drawString(itemDisplay[i].getName()+"  x"+gamestate.inventorymanager.backpack.get(itemDisplay[i]), 140+175*(itemnum%3), 200+25*(itemnum/3));
					itemnum++;
				}

				if(itemDisplay[itemSelected]!=null){
					g.setColor(new Color(255, 255, 255));
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
					if(!itemDisplay[itemSelected].getDescrShort().equals("meep")){
						g.drawString(itemDisplay[itemSelected].getDescrShort(), 295, 55);
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
						g.drawImage(Assets.Downarrow, 385, 384,null);
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
						for(int i=0; i<tempSchmuck.getItemSlots(); i++){
							if(tempSchmuck.getItems()[i] == null){
								g.drawString("Item slot "+(i+1)+" : Nothing", 300,240+50*i);
							}
							else{
								g.drawString("Item slot "+(i+1)+" "+tempSchmuck.getItems()[i].getName(),300,240+50*i);
								if(!tempSchmuck.getItems()[i].getDescrShort().equals("meep")){
									g.setFont(new Font("Chewy", Font.PLAIN, 12));
									g.drawString(tempSchmuck.getItems()[i].getDescrShort(),325,255+50*i);
									g.setFont(new Font("Chewy", Font.PLAIN, 18));
								}
								
							}
						}
						g.drawString(itemDisplay[itemSelected].name,500,240+50*itemslot);
						if(!itemDisplay[itemSelected].getDescrShort().equals("meep")){
							g.setFont(new Font("Chewy", Font.PLAIN, 12));
							g.drawString(itemDisplay[itemSelected].getDescrShort(),500,255+50*itemslot);
						}
					}
					if(useitemChosen){
						g.setColor(new Color(102, 178,255));
						g.fillRect(140, 175, 150, 225);
						g.drawImage(tempSchmuck.getMenuSprite(), 140, 175,150,225, null);
						g.setColor(new Color(0, 0,0));
						g.setFont(new Font("Chewy", Font.PLAIN, 12));
						g.drawString((int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)+"/"+(int)(Math.pow(tempSchmuck.Lvl,2)*10)+" Exp",575,190);
						g.drawString(itemDisplay[itemSelected].getName()+": "+itemDisplay[itemSelected].getDescrShort(),440,210);
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
		
	}

	@Override
	public void init() {
		
	}
	

}
