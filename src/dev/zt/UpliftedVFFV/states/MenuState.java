package dev.zt.UpliftedVFFV.states;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.utils.Utils;

//This is the menu state that is called up by pressing z during the game state.
//This displays info about party, inventory and everything else later.
public class MenuState extends State {
	
	private static final long serialVersionUID = 1L;

	private AudioManager audio;
	
	private BufferedImage window, window2, window3, window4, window5;
	private GameState gamestate;
	//Menu cursor and option pointers.
	private int optionSelected, characterSelected, itemSelected, itemPointer, 
		backpackLocation, skillSelected, skillPointer, skillLocation, equipSelected, equipPointer, equipLocation, characterTab;
	private int itemOption, itemslot, backpackTab, backpackDisplaySize, quipPointer, quitPointer;
	//Menu state indicators.
	private boolean optionChosen,characterChosen, itemChosen, equipChosen, useitemChosen, exit;
	//Menu logic indicators.
	private boolean  toggleXtraInfo, bypassSelection, progFlag;
	
	//KeyListener delay variables.
	private int delayCursor = 120;
	private int delaySelection = 200;
	
	StateManager statemanager;
	ArrayList<Character> party= new ArrayList<Character>();
	
	//Backpack sorting arrays;
	Set<Item> temp;
	ArrayList<ArrayList<Item>> tempBackpack;
	ArrayList<Item> itemDisplayConsumable, itemDisplayEquip, itemDisplayMisc, itemDisplayKey;
	
	public MenuState(Game game, StateManager sm, GameState gs){
		super(game, sm);
		setStateType("menu");
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		window2 = ImageLoader.loadImage("/ui/Window/WindowBlue2.png");
		window3 = ImageLoader.loadImage("/ui/Window/WindowBlack.png");
		window4 = ImageLoader.loadImage("/ui/Window/WindowYellowPaper.png");
		window5 = ImageLoader.loadImage("/ui/Window/WindowClear.png");
		this.gamestate=gs;
		audio = game.getAudiomanager();
		optionSelected=0;
		optionChosen=false;
		exit=false;
		characterSelected=0;
		itemSelected=0;
		itemPointer=0;
		backpackLocation=0;
		characterTab = 0;
		skillSelected=0;
		skillPointer=0;
		skillLocation=0;
		equipSelected = 0;
		equipPointer = 0;
		equipLocation = 0;
		itemslot = 0;
		backpackTab = 0;
		
		//Flag for showing extra info on character screen.
		toggleXtraInfo = false;
		
		//Equip/Dequip.
		quipPointer = 0;
		
		//Boolean for bypassing second stage of equipping items.
		bypassSelection = false;
		
		//Delay after using/equipping an item.
		progFlag = false;
		
		//Number of items to display in backpack.
		backpackDisplaySize = 13;
		
		//Pointer for quit game menu.
		quitPointer = 0;
		
		//Sort backpack for display.
		temp = gamestate.inventorymanager.backpack.keySet();
		tempBackpack = new ArrayList<ArrayList<Item>>();
		itemDisplayConsumable = new ArrayList<Item>();
		itemDisplayEquip = new ArrayList<Item>();
		itemDisplayMisc = new ArrayList<Item>();
		itemDisplayKey = new ArrayList<Item>();
		//Split backpack up into categories.
		for(Item item : temp.toArray(new Item[10])){
			if(item != null){
				switch(item.getSlot()){
				case 0:
					//Consumable.
					itemDisplayConsumable.add(item);
					break;
				case 1:
					//Equipment.
					itemDisplayEquip.add(item);
					break;
				case 2:
					//Miscellaneous.
					itemDisplayMisc.add(item);
					break;
				case 3:
					//Key items.
					itemDisplayKey.add(item);
					break;
				}
			} else{
				break;
			}
		}
		
		tempBackpack.add(itemDisplayConsumable);
		tempBackpack.add(itemDisplayEquip);
		tempBackpack.add(itemDisplayMisc);
		tempBackpack.add(itemDisplayKey);
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			//pressing exit will move back one screen or deselect stuff.
			if(game.getKeyManager().x){
				audio.playSound("/Audio/ui_upgrade_ability_01.wav", false);
				exit=true;
				game.getKeyManager().disable(delaySelection);
			}
			
			//if you havent selected a subcategory yet, space, up and down will control that.
			if(optionChosen==false){
				if(game.getKeyManager().space){
					audio.playSound("/Audio/paper_pickup_01.wav", false);
					optionChosen=true;
					game.getKeyManager().disable(delaySelection);
				}
				if(game.getKeyManager().up){
					if(optionSelected>0){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						optionSelected--;
						game.getKeyManager().disable(delayCursor);
					}
				}
				if(game.getKeyManager().down){
					if(optionSelected<5){			//4 options currently. change this number later wen more are added
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						optionSelected++;
						game.getKeyManager().disable(delayCursor);
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
								audio.playSound("/Audio/paper_pickup_01.wav", false);
								characterChosen=true;
								characterTab = 0;
								skillSelected = 0;
								skillPointer=0;
								skillLocation=0;
								equipSelected = 0;
								equipPointer = 0;
								equipLocation = 0;
								game.getKeyManager().disable(delaySelection);
							}
							if(game.getKeyManager().right){
								if(characterSelected<gamestate.partymanager.party.size()-1){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterSelected++;
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().left){
								if(characterSelected>0){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterSelected--;
									game.getKeyManager().disable(delayCursor);
								}
							}
						}
						else{
							if(characterTab == 0){
								//Skills tab.
								if(game.getKeyManager().space){
									//Extra skill info.
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									toggleXtraInfo = !toggleXtraInfo;
									game.getKeyManager().disable(delaySelection);
								}
								if(game.getKeyManager().down){
									if(skillSelected<gamestate.partymanager.party.get(characterSelected).skills.size()-1){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										skillSelected++;
										if(skillPointer==3){
											skillLocation++;
										}
										else{
											skillPointer++;
										}
										game.getKeyManager().disable(delayCursor);
									}
								}
								if(game.getKeyManager().up){
									if(skillSelected>0){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										skillSelected--;
										if(skillPointer==0){
											skillLocation--;
										}
										else{
											skillPointer--;
										}
										game.getKeyManager().disable(delayCursor);
									}
								}
								if(game.getKeyManager().right){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterTab++;
									game.getKeyManager().disable(delayCursor);
								}						
							} else if (characterTab == 1){
								//Equipment tab.
								if(!toggleXtraInfo){
									if(game.getKeyManager().space){
										//Toggle Equip/Unequip mode.
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										toggleXtraInfo = !toggleXtraInfo;
										quipPointer = 0;
										game.getKeyManager().disable(delaySelection);
									}
									if(game.getKeyManager().down){
										if(equipSelected < gamestate.partymanager.party.get(characterSelected).getItemSlots() - 1){
											audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
											equipSelected++;
											if(equipPointer == 3){
												equipLocation++;
											} else {
												equipPointer++;
											}
											game.getKeyManager().disable(delayCursor);
										}
									}
									if(game.getKeyManager().up){
										if(equipSelected > 0){
											audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
											equipSelected--;
											if(equipPointer == 0){
												equipLocation--;
											} else {
												equipPointer--;
											}
											game.getKeyManager().disable(delayCursor);
										}
									}
									if(game.getKeyManager().right){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										characterTab++;
										game.getKeyManager().disable(delayCursor);
									}
									if(game.getKeyManager().left){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										characterTab--;
										try {
											Thread.sleep(delayCursor);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								} else{
									//Equip/Dequip menu.
									if(game.getKeyManager().space){
										//Equip/Unequip item.
										audio.playSound("/Audio/paper_pickup_01.wav", false);
										switch(quipPointer){
											case 0: 
												//Equip Item.
												toggleXtraInfo = false;
												bypassSelection = true;
												//Go to inventory and set lock/bypass.
												optionSelected = 1;
												backpackTab = 1;
												//Reset item pointer/location
												itemPointer = 0;
												itemSelected = 0;
												backpackLocation = 0;
												itemslot = equipSelected;
												itemChosen = false;
												break;
											case 1:
												//Unequip item.
												gamestate.partymanager.party.get(characterSelected).unEquip(equipSelected, gamestate.inventorymanager, game);
												refreshBackpack();
												toggleXtraInfo = false;
												break;
											case 2:
												toggleXtraInfo = false;
												break;
										}
										game.getKeyManager().disable(delaySelection);
									}	
									if(game.getKeyManager().down){
											if(quipPointer < 2){
												audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
												quipPointer++;
											}
											game.getKeyManager().disable(delayCursor);
									}
									if(game.getKeyManager().up){
										if(quipPointer > 0){
											audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
											quipPointer--;
											game.getKeyManager().disable(delayCursor);
										}
									}						
								}
							} else if(characterTab == 2){
								//Biography tab.
								if(game.getKeyManager().left){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterTab--;
									game.getKeyManager().disable(delayCursor);
								}
							}
						}
						break;
					
					//Option 2 is inventory.
					case 1:
						Item tempItem = null;
						if(tempBackpack.get(backpackTab).size() > 0){	
							tempItem = tempBackpack.get(backpackTab).get(itemSelected);
						}
						//Equip item. Choose party member/slot to equip item in.
						if(equipChosen){
							if(game.getKeyManager().space){
								if(progFlag){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									progFlag = false;
									exit = true;
								} else{
//									if(gamestate.partymanager.party.get(characterSelected).getLvl() >= tempItem.getLvlReq()*(1-gamestate.partymanager.party.get(characterSelected).getLvlReqMod())){
										audio.playSound("/Audio/option_toggle.wav", false);
										gamestate.partymanager.party.get(characterSelected).equip(tempItem, itemslot, gamestate.inventorymanager, game);
										refreshBackpack();
										progFlag = true;
										itemChosen = false;
//									}
//									else{
//										audio.playSound("/Audio/option_toggle.wav", false);//meep merp sound
//										progFlag = true;
//									}
									
								}
								game.getKeyManager().disable(delaySelection);
							}
							if(game.getKeyManager().right){
								if(characterSelected<gamestate.partymanager.party.size()-1){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterSelected++;
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().left){
								if(characterSelected>0){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterSelected--;
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().up){
								if(!progFlag){
									if(itemslot>0){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										itemslot--;
										game.getKeyManager().disable(delayCursor);
									}
								}
							}
							if(game.getKeyManager().down){
								if(!progFlag){
									if(itemslot<gamestate.partymanager.party.get(characterSelected).getItemSlots()-1){			
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										itemslot++;
										game.getKeyManager().disable(delayCursor);
									}
								}
							}
						}
						else if(useitemChosen){
							//Use item. Select which party member to use item on.
							if(game.getKeyManager().space){
								if(progFlag){
									progFlag = false;
									exit = true;
								} else{
									audio.playSound("/Audio/option_toggle.wav", false);
									tempItem.use(gamestate.partymanager.party.get(characterSelected),game, statemanager, gamestate);
									if(tempItem.isConsummable()){
										gamestate.inventorymanager.use(tempItem);
										itemChosen = false;
										refreshBackpack();
									}
									progFlag = true;
								}
								game.getKeyManager().disable(delaySelection);
							}
							if(game.getKeyManager().right){
								if(characterSelected<gamestate.partymanager.party.size()-1){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterSelected++;
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().left){
								if(characterSelected>0){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									characterSelected--;
									game.getKeyManager().disable(delayCursor);
								}
							}
						}
						else if(!itemChosen){
							//No item selected. Arrows to navigate menu, space to select item.
							if(game.getKeyManager().space){
								//Select item;
								if(tempItem != null){
									if(!gamestate.inventorymanager.backpack.isEmpty() && !bypassSelection){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										itemChosen=true;
									} else if(!gamestate.inventorymanager.backpack.isEmpty() && bypassSelection){
										if(tempBackpack.get(backpackTab).size() > 0){	
											tempItem = tempBackpack.get(backpackTab).get(itemSelected);
										}
//										if(gamestate.partymanager.party.get(characterSelected).getLvl() >= tempItem.getLvlReq()*(1-gamestate.partymanager.party.get(characterSelected).getLvlReqMod())){
											audio.playSound("/Audio/option_toggle.wav", false);
											gamestate.partymanager.party.get(characterSelected).equip(tempItem, itemslot, gamestate.inventorymanager, game);
//										}
//										else{
//											audio.playSound("/Audio/option_toggle.wav", false); // lets get some meep merp in here
//										}
										refreshBackpack();
										bypassSelection = false;
										optionSelected = 0;
										characterTab = 1;
									}	
								}
								game.getKeyManager().disable(delaySelection);
							}
							if(game.getKeyManager().right){
								//Change tab.
								if(!bypassSelection){
									if(backpackTab < 3){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										backpackTab++;
										itemSelected = 0;
										itemPointer = 0;
										backpackLocation = 0;
										game.getKeyManager().disable(delayCursor);
									}
								}
							}
							if(game.getKeyManager().left){
								//Change tab.
								if(!bypassSelection){
									if(backpackTab > 0){
										audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
										backpackTab--;
										itemSelected = 0;
										itemPointer = 0;
										backpackLocation = 0;
										game.getKeyManager().disable(delayCursor);
									}
								}
							}
							if(game.getKeyManager().down){
								//Scroll through items.
								if(itemSelected < tempBackpack.get(backpackTab).size() - 1){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									itemSelected++;
									if(itemPointer >= backpackDisplaySize - 1){
										backpackLocation++;
									}
									else{
										itemPointer++;
									}
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().up){
								//Scroll through items.
								if(itemSelected > 0){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									itemSelected--;
								if(itemPointer == 0){
									backpackLocation--;
								}
								else{
									itemPointer--;
								}
								game.getKeyManager().disable(delayCursor);
								}
							}
							break;
						}
						else{
							//Item selected. Up/Down to select what to do with item (itemOption 0 = use, 1 = equip).
							if(game.getKeyManager().down){
								if(itemOption < 1){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									itemOption++;
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().up){
								if(itemOption > 0){
									audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
									itemOption--;
									game.getKeyManager().disable(delayCursor);
								}
							}
							if(game.getKeyManager().space){
								if(tempItem != null){
									if(itemOption == 0){
										if(tempItem.isUsedfromMenu()){
//											itemChosen = false;
											if(tempItem.targeted){
												audio.playSound("/Audio/paper_pickup_01.wav", false);
												useitemChosen = true;
											}
											else{
												audio.playSound("/Audio/option_toggle.wav", false);
												tempItem.use(game, statemanager, gamestate);
												if(tempItem.isConsummable()){
													gamestate.inventorymanager.use(tempItem);
													itemChosen = false;
													refreshBackpack();
												}											}
											
										}
									} else if(itemOption == 1){
										if(tempItem.getSlot() == 1){
											audio.playSound("/Audio/paper_pickup_01.wav", false);
//											itemChosen = false;
											equipChosen = true;
										}
									}	
								}
								game.getKeyManager().disable(delaySelection);
							}
						}
						break;
					case 2:
						//TODO: Map.
						break;
					case 3:
						//TODO: Employee Directory/Worstiary. Should have own state perhaps.
						break;
					case 4:
						if(game.getKeyManager().space){
							audio.playSound("/Audio/ui_upgrade_ability_01.wav", false);
							exit=true;
							game.getKeyManager().disable(delaySelection);
						}
						break;
					case 5:
						//Exit game.
						if(game.getKeyManager().space){
							audio.playSound("/Audio/ui_upgrade_ability_01.wav", false);
							if(quitPointer == 1){
								optionChosen = false;
							} else if(quitPointer == 0){
								audio.playSound("/Audio/option_toggle.wav", false);
								StateManager.getStates().pop();
								StateManager.getStates().pop();
							}
							game.getKeyManager().disable(delaySelection);
						}		
						if(game.getKeyManager().up){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							if(quitPointer > 0){
								quitPointer--;
							}
							game.getKeyManager().disable(delayCursor);
						}
						if(game.getKeyManager().down){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							if(quitPointer < 1){
								quitPointer++;
							}
							game.getKeyManager().disable(delayCursor);
						}
						break;				
				}			
			}
		}
	}


	public void render(Graphics g) {
		
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
		//if x is pressed, the menu will go back one screen.
		if(exit==true){
			if(equipChosen || useitemChosen){
				equipChosen=false;
				useitemChosen=false;
			}
			else if(characterChosen==true){
				characterChosen=false;
				if(bypassSelection){
//					optionChosen=false;
					optionSelected = 0;
					characterChosen = true;
				}
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
			progFlag = false;		//This line fixes "Custom Message" staying around if x is pressed.
			toggleXtraInfo = false;
			bypassSelection = false;
			exit=false;
		}
		
		String[] options = {"Party", "Inventory", "Map", "Directory", "To-Do", "Quit"};
		Utils.drawMenu(g, window, options, Color.black, 25, new Font("Courier", Font.PLAIN, 18),optionSelected, 5, 5, 125, 380, !optionChosen);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString(gamestate.Script + " Script", 25, 375);
		
		if(optionChosen){
		switch(optionSelected){
			//Character view screen.
			case 0:
				Schmuck tempSchmuck = gamestate.partymanager.party.get(characterSelected);
				drawCharacterPane(g, tempSchmuck);
				
				//2nd level of character info tab.
				if(characterChosen==true){
					Utils.drawDialogueBox(g, window, "", 18, Color.black, 132, 5, 496, 384, 16, characterChosen);
					g.setColor(Color.white);
					g.fillRect(145, 20, 150, 200);
					g.drawImage(tempSchmuck.getMenuSprite(), 140, 10, 135, 201, null);
					g.setColor(Color.black);
					g.setFont(new Font("Courier", Font.PLAIN, 12));
					g.drawString(tempSchmuck.getName() + " Lvl " + tempSchmuck.getLvl(), 145, 30);
					g.setColor(Color.lightGray);
					g.fillRect(145, 212, 200, 28);
					g.setColor(Color.white);
					g.fillRect(147, 214, 46, 24);
					g.fillRect(197, 214, 96, 24);
					g.fillRect(297, 214, 46, 24);
					g.setColor(Color.black);
					g.drawString("Skills", 150, 232);
					g.drawString("Equipment", 200, 232);
					g.drawString("Bio", 300, 232);
					
					if(characterTab == 0){
						//Skills tab.
						g.setColor(Color.yellow);
						g.fillRect(147, 214, 46, 24);
						g.setColor(Color.black);
						g.drawString("Skills", 152, 232);
										
						//Draw scrolling display options and icons
						int skillnum = 0;                                                                                                                                                                                                                                                                                       
						Utils.drawDialogueBox(g, window2, "", 18, Color.black, 140, 240, 250, 150, 16, characterChosen);
						//Draw custom cursor.
						Utils.drawCursor(g, window2, 140, 245 + 36 * skillPointer, 250, 32, characterChosen);
						if(skillLocation!=0){
							g.drawImage(Assets.Uparrow, 265 - Assets.Uparrow.getWidth() / 2, 225, null);
						}
						if(skillLocation!=tempSchmuck.skills.size()-4 && tempSchmuck.skills.size()>4){
							g.drawImage(Assets.Downarrow, 265 - Assets.Downarrow.getWidth() / 2, 390, null);
						}
						for(int i=skillLocation;i<=skillLocation+3 && i<tempSchmuck.skills.size();i++){			
							g.drawString(tempSchmuck.skills.get(i).getName(),150, 274 + 36 * skillnum);
							g.drawString((int)(tempSchmuck.skills.get(i).getCost() * (1-tempSchmuck.getMpCost())) + " Mp", 330, 274 + 36 * skillnum);
		
							skillnum++;
						}	
						for(int i = 0; i < 4 && i < tempSchmuck.skills.size(); i++){	
	//						g.drawImage(tempSchmuck.skills.get(skillLocation+i).getIcon(), 355, 254 + 36 * i, null);
						}
						
						//Draw info box.
						Utils.drawDialogueBox(g, window2, tempSchmuck.skills.get(skillSelected).getDescr(), 18, Color.black, 396, 190, 235, 200, 16, characterChosen);
	//					if(!tempSchmuck.skills.get(skillSelected).getDescr().equals("meep")){
	//						int y = 245;
	//						for (String line : tempSchmuck.skills.get(skillSelected).getDescr().split("\n"))
	//					        g.drawString(line, 410, y += g.getFontMetrics().getHeight());
	//					}
						//Draw extra skill info.
						if(toggleXtraInfo){
							Utils.drawDialogueBox(g, window2, tempSchmuck.skills.get(skillSelected).getDescrShort(), 16, Color.black, 275, 225 + 36 * skillPointer, 200, 72, 16, true);
						}
					} else if(characterTab == 1){
						//Equipment tab.
						g.setColor(Color.yellow);
						g.fillRect(197, 214, 96, 24);
						g.setColor(Color.black);
						g.drawString("Equipment", 202, 232);
						
						//Draw list and icons.
						Utils.drawDialogueBox(g, window2, "", 18, Color.black, 140, 240, 250, 150, 16, characterChosen);
						//Draw cursor and arrows.
						Utils.drawCursor(g, window2, 140, 243 + 36 * equipPointer, 250, 32, characterChosen);
						if(equipLocation != 0){
							g.drawImage(Assets.Uparrow, 265 - Assets.Uparrow.getWidth() / 2, 225, null);
						}
						if(equipLocation != tempSchmuck.getItemSlots() - 4 && tempSchmuck.getItemSlots() > 3){
							g.drawImage(Assets.Downarrow, 265 - Assets.Downarrow.getWidth() / 2, 390, null);
						}
						int displayIndex = 0;
						for(int i = equipLocation; i <= equipLocation + 3 && i < tempSchmuck.getItemSlots(); i++){			
							if(tempSchmuck.getItems()[i] == null){
								g.setColor(Color.black);
								g.drawString((i+1)+". Nothing", 160, 272 + 36 * displayIndex);
//								g.fillRect(175, 249 + 36 * displayIndex, 36, 36);
//								g.setColor(Color.white);
//								g.fillRect(177, 251 + 36 * displayIndex, 32, 32);
							}
							else{
								g.setColor(Color.black);
								g.drawString((i+1)+". "+tempSchmuck.getItems()[i].getName(), 160, 272 + 36 * displayIndex);
//								g.fillRect(175, 250 + 36 * displayIndex, 36, 36);
//								g.setColor(Color.white);
//								g.drawImage(tempSchmuck.getItems()[i].getIcon(), 177, 252 + 36 * displayIndex, null);
							}
							displayIndex++;
						}
						
						//Draw info box.
						if(tempSchmuck.getItems()[equipSelected] != null){
							Utils.drawDialogueBox(g, window2, tempSchmuck.getItems()[equipSelected].getDescrShort(), 18, Color.black, 396, 190, 235, 200, 16, characterChosen);
						} else{
							Utils.drawDialogueBox(g, window2, "An empty pocket.", 18, Color.black, 396, 190, 235, 200, 16, characterChosen);
						}
						
						//Draw unequip option.
						if(toggleXtraInfo){
							String[] options1 = {"Equip", "Unequip", "Exit"};
							Utils.drawMenu(g, window3, options1, Color.white, 16,new Font("Courier", Font.PLAIN, 16), quipPointer, 280, 222 + 36 * equipPointer, 120, 80, 1, 3, 0, 16, true, true);
						}
						
					} else if(characterTab == 2){
						//Biography tab.
						g.setColor(Color.yellow);
						g.fillRect(297, 214, 46, 24);
						g.setColor(Color.black);
						g.drawString("Bio", 302, 232);
						
						//Draw info box.
						Utils.drawDialogueBox(g, window2, tempSchmuck.getBioShort(), 18, Color.black, 140, 240, 480, 150, 16, characterChosen);
					}
					
					//Draw Alignment bars.
					g.setFont(new Font("Courier", Font.PLAIN, 18));
					g.setColor(Color.black);
					for(int i = 0; i < 6; i++){
						g.fillRect(325, 42 + 25 * i, 16, 16);
					}
					int alignment = (int)tempSchmuck.getElemAlignment() - 1;
					if(alignment >= 0){
						g.drawRect(324, 41 + 25 * alignment, 17, 17);
					} else{
						g.drawRect(324, 166, 17, 17);
					}
					
					int remaining = (tempSchmuck.getPrismaticPoints() - tempSchmuck.getBuffedElemPoints()[4] 
							- tempSchmuck.getBuffedElemPoints()[3] - tempSchmuck.getBuffedElemPoints()[2] - tempSchmuck.getBuffedElemPoints()[1]
							- tempSchmuck.getBuffedElemPoints()[0]);
					g.setColor(Color.red);				
					g.fillRect(326, 43, 14, 14);
					g.fillRect(345, 44, tempSchmuck.getBuffedElemPoints()[0] * 3, 12);
					g.drawString(tempSchmuck.getBuffedElemPoints()[0] + "", 575, 57);
					g.setColor(Color.blue);
					g.fillRect(326, 68, 14, 14);
					g.fillRect(345, 69, tempSchmuck.getBuffedElemPoints()[1] * 3, 12);
					g.drawString(tempSchmuck.getBuffedElemPoints()[1] + "", 575, 82);
					g.setColor(Color.green);
					g.fillRect(326, 93, 14, 14);
					g.fillRect(345, 94, tempSchmuck.getBuffedElemPoints()[2] * 3, 12);
					g.drawString(tempSchmuck.getBuffedElemPoints()[2] + "", 575, 107);
					g.setColor(Color.yellow);
					g.fillRect(326, 118, 14, 14);
					g.fillRect(345, 119, tempSchmuck.getBuffedElemPoints()[3] * 3, 12);
					g.drawString(tempSchmuck.getBuffedElemPoints()[3] + "", 575, 132);
					g.setColor(new Color(128, 0, 128));
					g.fillRect(326, 143, 14, 14);
					g.fillRect(345, 144, tempSchmuck.getBuffedElemPoints()[4] * 3, 12);
					g.drawString(tempSchmuck.getBuffedElemPoints()[4] + "", 575, 157);
					g.setColor(Color.white);
					g.fillRect(326, 168, 14, 14);
					g.fillRect(345, 169,  remaining * 3 , 12);
					g.drawString(remaining + "", 575, 182);
				}
				break;
			
			//Draw inventory.
			case 1:				
				//Build string array from current tab.
				String[] printThis = new String[tempBackpack.get(backpackTab).size()];
				String[] quantities = new String[tempBackpack.get(backpackTab).size()];
				for(int i = 0; i < tempBackpack.get(backpackTab).size(); i++){
					quantities[i] = " x " + gamestate.inventorymanager.backpack.get(tempBackpack.get(backpackTab).get(i));
					printThis[i] = tempBackpack.get(backpackTab).get(i).toString();
				}
				
				Utils.drawDialogueBox(g, window, "", 16, Color.black, 130, 48, 200, 365, 16, optionChosen && !(useitemChosen || equipChosen));

				
				Utils.drawMenu(g, window5, printThis, Color.black, 12, new Font("Courier", Font.PLAIN, 12),itemPointer, 130, 48, 150, 365, 1, backpackDisplaySize, 
						backpackLocation, 16, optionChosen && !(useitemChosen || equipChosen), true);
				
				Utils.drawMenu(g, window5, quantities, Color.black, 12, new Font("Courier", Font.PLAIN, 12),itemPointer, 270, 48, 200, 365, 1, backpackDisplaySize, 
						backpackLocation, 16, optionChosen && !(useitemChosen || equipChosen),false);
				
				Utils.drawDialogueBox(g, window, "", 16, Color.black, 335, 4, 300, 400, 16, optionChosen && !(useitemChosen || equipChosen));
				
				//Draw backpack tabs.
				String[] packTabs = {"Cons", "Equip", "Misc", "Key"};
				Utils.drawMenu(g, window, packTabs, Color.black, 13, new Font("Courier", Font.PLAIN, 13),backpackTab, 130, 2, 200, 32, 4, 1, 0, 16, optionChosen && !(useitemChosen || equipChosen), true);
				Item curItem = null;
				if(tempBackpack.get(backpackTab).size() > 0){	
					curItem = tempBackpack.get(backpackTab).get(itemSelected);
				}
				
				//Draw item icon and description.
				if(curItem != null){
					//Icon.
					g.drawImage(curItem.getIcon(), 414,	50, null);
					//Name.
					g.setFont(new Font("Courier", Font.PLAIN, 18));
					g.setColor(Color.black);
//					g.drawString(curItem.getName(), 350, 40);
					Utils.drawDialogueBox(g, window5, curItem.getName(), 18, Color.black, 340, 10, 290, 100, 16, optionChosen && !(useitemChosen || equipChosen));

					g.setFont(new Font("Courier", Font.PLAIN, 12));
					
					//Flavor.
					Utils.drawDialogueBox(g, window5, curItem.getDescr(), 12, Color.black, 350, 190, 260, 90, 16, optionChosen && !(useitemChosen || equipChosen));
					
					//Effects.
					Utils.drawDialogueBox(g, window5, curItem.getDescrShort(), 12, Color.black, 350, 300, 260, 80, 16, optionChosen && !(useitemChosen || equipChosen));

					//Tags.
					String tag = "Tags:  ";
					if(curItem.isConsummable()){
						tag = tag + "*Consumable* ";
					}
					if(curItem.isUsedfromMenu()){
						tag = tag + "*Menu* ";
					}
					if(curItem.isUsefromBattle()){
						tag = tag + "*Battle* ";
					}
					if(curItem.isSellable()){
						tag = tag + "*Sell* ";
					}
					if(curItem.isLegendary()){
						tag = tag + "*LEGENDARY* ";
					}
					g.drawString(tag, 350, 400);
				} else{
					g.drawString("Lint", 350, 400);
				}

				if(backpackLocation > 0){
					g.drawImage(Assets.Uparrow, 230 - Assets.Uparrow.getWidth() / 2, 38, null);
				}
				if(backpackLocation < tempBackpack.get(backpackTab).size() - backpackDisplaySize){
					if(gamestate.inventorymanager.backpack.size()!=0){
						g.drawImage(Assets.Downarrow, 230 - Assets.Downarrow.getWidth() / 2, 392, null);
					}
				}
				//Draw item action menu.
				if(itemChosen==true){
					if(curItem != null){
						Utils.drawDialogueBox(g, window2, "", 18, Color.black, 300, 36 + 25 * itemPointer, 80, 80, 16, itemChosen);
						Utils.drawCursor(g, window2, 299, 40 + 25 * itemPointer + 38 * itemOption, 80, 32, itemChosen);
						
						g.setFont(new Font("Courier", Font.PLAIN, 18));
						if(curItem.isUsedfromMenu()){
							g.setColor(Color.black);
						} else{
							g.setColor(Color.lightGray);
						}
						g.drawString("Use", 320, 68 + 25 * itemPointer);
						
						if(curItem.slot == 1){
							g.setColor(Color.black);
						} else{
							g.setColor(Color.lightGray);
						}
						g.drawString("Equip", 320, 105 + 25 * itemPointer);
					}
										
				}
				//Select target menu.
				if(equipChosen || useitemChosen){					
					tempSchmuck = gamestate.partymanager.party.get(characterSelected);
					drawCharacterPane(g, tempSchmuck);					
					//Equipping stuff.
					if(equipChosen && !progFlag){
						//Show dialogue box indicating equipment usage.
/*						g.setColor(Color.yellow);
						Stroke oldStroke = ((Graphics2D) g).getStroke();
						((Graphics2D) g).setStroke(new BasicStroke(3));
						g.drawRect(450, 240 + itemslot * 40, 36, 36);
						((Graphics2D) g).setStroke(oldStroke);
						g.drawImage(curItem.getIcon(), 452, 242 + itemslot * 40, null);*/
						Utils.drawCursor(g, window2, 450, 240 + 40 * itemslot, 150, 25, false);
						FontMetrics metrics = g.getFontMetrics();
						Utils.drawDialogueBox(g, window2, curItem.getName(), 12, Color.black,  150 + characterSelected * 100, 120, metrics.stringWidth(curItem.getName()) + 8, 25, 16, true);
					} else if(equipChosen && progFlag){
//							Utils.drawDialogueBox(g, window3, "Item Equipped!", 16, Color.white,  320 - 50, 208 - 100, 200, 32, 16, true);						
					}
					//Item usage.
					if(useitemChosen && !progFlag){
						//Show dialogue box indicating item usage.
						FontMetrics metrics = g.getFontMetrics();
						Utils.drawDialogueBox(g, window2, curItem.getName(), 16, Color.black,  150 + characterSelected * 100, 120, metrics.stringWidth(curItem.getName()) + 8, 25, 16, true);
					} else if(useitemChosen && progFlag){
//						Utils.drawDialogueBox(g, window3, "Item Used!", 16, Color.white,  320 - 50, 208 - 100, 200, 32, 16, true);
					}
				}
				break;
			//TODO: Map.
			case 2:
				break;
			//TODO: Directory.
			case 3:
				break;
			//To-do List
			case 4:
				Utils.drawDialogueBox(g, window4, "", 18, Color.black, 140, 5, 400, 400, 48, optionChosen);
				g.setColor(Color.black);
				g.setFont(new Font("Courier", Font.PLAIN, 18));
				g.drawString("To - Do List", 300, 30);
				g.drawString("1: Operate Elevators", 152, 50);
				int numquests = 1;
				for(int quest = 0; quest < gamestate.questmanager.quests.length; quest++){
					if(gamestate.questmanager.quests[quest] != 0 && gamestate.questmanager.getObjective(quest, gamestate.questmanager.quests[quest]) != ""){
						g.drawString(numquests+1+": " + gamestate.questmanager.getObjective(quest, gamestate.questmanager.quests[quest]), 152, 50+18*numquests);
						numquests++;
					}
				}
				g.drawString(numquests+1+": "+"? ? ?", 152, 68+18*(numquests-1));
				break;
			//Quit game.
			case 5:
				if(optionChosen){
					String[] quitOptions = {"YES I Would Like to Quit the Game.", "NO I Made a Mistake and Would Rather Keep Playing"};
					Utils.drawMenu(g, window3, quitOptions, Color.white, 25, new Font("Courier", Font.PLAIN, 18), quitPointer, 128, 128, 400, 75, true);
				}
				break;				
		}
	}
	}

	@Override
	public void init() {
		
	}
	
	//Helper that draws character info screen to cut back on repeated code.
	private void drawCharacterPane(Graphics g, Schmuck myTempSchmuck){
		//Draw character screen.
		Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 5, 480, 150, 16, optionChosen);
		//Draw custom Cursor.
		Utils.drawCursor(g, window, 138 + characterSelected * 100, 14, 100, 128, false);
		for(int i = 0; i < gamestate.partymanager.party.size(); i++){
			g.drawString(gamestate.partymanager.party.get(i).getName(), 160 + 100 * i, 30);
			g.drawImage(gamestate.partymanager.party.get(i).getMenuSprite(), 144 + 100 * i, 15, 94, 141, null);
		}
		
		//Stats.
		Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 170, 480, 225, 16, optionChosen);
		Schmuck tempSchmuck = myTempSchmuck;
		g.setColor(Color.white);
		g.fillRect(148, 182, 142, 218);
		g.drawImage(tempSchmuck.getMenuSprite(), 140, 175, 150, 225, null);
		g.setColor(Color.black);
		g.setFont(new Font("Courier", Font.PLAIN, 12));
		g.drawString(tempSchmuck.getName() +" Lvl "+tempSchmuck.getLvl(), 150, 194);
		g.drawString((int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)+"/"+(int)(Math.pow(tempSchmuck.Lvl,2)*10)+" Exp", 510, 194);
		g.setColor(Color.darkGray);
		g.fillRect(338, 188, 160, 5);
		g.setColor(Color.green);
		g.fillRect(338, 188, 160*(int)(tempSchmuck.getExp()-Math.pow(tempSchmuck.Lvl-1,2)*10)/(int)(Math.pow(tempSchmuck.Lvl,2)*10), 5);
		g.setColor(Color.black);
		g.setFont(new Font("Courier", Font.PLAIN, 18));
		g.drawString("Hp: ", 300, 220);
		g.drawString("Bp: ", 300, 245);
		g.drawString("Pow: ", 300, 270);
		g.drawString("Def: ", 300, 295);
		g.drawString("Spd: ", 300, 320);
		g.drawString("Skl: ", 300, 345);
		g.drawString("Int: ", 300, 370);
		g.drawString("Luk: ", 300, 395);
		
		FontMetrics metrics = g.getFontMetrics(new Font("Courier", Font.PLAIN, 18));
		for(int i = 0; i < tempSchmuck.baseStats.length; i++){
			if(i <= 1){
				if(i == 0){
					g.setColor(Color.black);
					g.drawString(tempSchmuck.getCurrentHp() + "/", 340, 220);
					if(tempSchmuck.buffedStats[i] != tempSchmuck.baseStats[i]){
						if(tempSchmuck.buffedStats[i] > tempSchmuck.baseStats[i]){
							g.setColor(Color.green);
						} else if (tempSchmuck.buffedStats[i] < tempSchmuck.baseStats[i]){
							g.setColor(Color.red);
						}
					}
					g.drawString(tempSchmuck.getMaxHp() + "", 340 + metrics.stringWidth(tempSchmuck.getCurrentHp() + "/"), 220);
				}
				else{
					g.setColor(Color.black);
					g.drawString(tempSchmuck.getCurrentBp() + "/", 340, 220 + 25);
					if(tempSchmuck.buffedStats[i] != tempSchmuck.baseStats[i]){
						if(tempSchmuck.buffedStats[i] > tempSchmuck.baseStats[i]){
							g.setColor(Color.green);
						} else if (tempSchmuck.buffedStats[i] < tempSchmuck.baseStats[i]){
							g.setColor(Color.red);
						}
					}
					g.drawString(tempSchmuck.getMaxBp() + "", 340 + metrics.stringWidth(tempSchmuck.getCurrentBp() + "/"), 220 + 25);
				}
			} else{
				g.drawString(" "+tempSchmuck.baseStats[i] + "", 340, 220 + 25 * i);
				if(tempSchmuck.buffedStats[i] != tempSchmuck.baseStats[i]){
					if(tempSchmuck.buffedStats[i] > tempSchmuck.baseStats[i]){
						g.setColor(Color.green);
					} else if (tempSchmuck.buffedStats[i] < tempSchmuck.baseStats[i]){
						g.setColor(Color.red);
					}
					g.drawString("(" + tempSchmuck.buffedStats[i] + ")", 345 + metrics.stringWidth(tempSchmuck.baseStats[i] + " "), 220 + 25 * i);
				}
			}
			g.setColor(Color.black);
		}
		
		//Alignment.
		g.setFont(new Font("Courier", Font.PLAIN, 12));
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
				g.setColor(new Color(128, 0, 128));
				break;
			case 6:
				g.setColor(Color.black);
				break;
		}
		g.fillRect(309, 185, 14, 14);
		
		//Items.
		g.setFont(new Font("Courier", Font.PLAIN, 18));
		g.setColor(Color.black);
		g.drawString("Equipment", 455, 235);
		g.setFont(new Font("Courier", Font.PLAIN, 12));
		for(int i = 0; i < tempSchmuck.getItemSlots(); i++){
			if(tempSchmuck.getItems()[i] == null){
//				g.setColor(Color.black);
				g.drawString((i+1)+". N/A", 450, 260 + 40 * i);
//				g.fillRect(450, 240 + i * 40, 36, 36);
			}
			else{
				g.setColor(Color.black);
				g.drawString((i+1)+". "+tempSchmuck.getItems()[i].getName(), 450, 260 + 40 * i);
//				g.fillRect(450, 240 + i * 40, 36, 36);
//				g.drawImage(tempSchmuck.getItems()[i].getIcon(), 452, 242 + i * 40, null);
			}
		}
	}
	
	private void refreshBackpack(){
		tempBackpack.clear();
		itemDisplayConsumable.clear();
		itemDisplayEquip.clear();
		itemDisplayMisc.clear();
		itemDisplayKey.clear();
		for(Item item : temp.toArray(new Item[10])){
			if(item != null){
				switch(item.getSlot()){
				case 0:
					//Consumable.
					itemDisplayConsumable.add(item);
					break;
				case 1:
					//Equipment.
					itemDisplayEquip.add(item);
					break;
				case 2:
					//Miscellaneous.
					itemDisplayMisc.add(item);
					break;
				case 3:
					//Key items.
					itemDisplayKey.add(item);
					break;
				}
			} else{
				break;
			}
		}
		tempBackpack.add(itemDisplayConsumable);
		tempBackpack.add(itemDisplayEquip);
		tempBackpack.add(itemDisplayMisc);
		tempBackpack.add(itemDisplayKey);
		if(itemSelected == tempBackpack.get(backpackTab).size()){
			itemPointer--;
			itemSelected = tempBackpack.get(backpackTab).size()-1;
		}
	}
}