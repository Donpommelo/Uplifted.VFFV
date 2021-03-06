package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Set;
import java.util.TreeMap;
import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.utils.Utils;

//State for when the player is shoppin'. Modified version of ChoiceBranchState.
public class ShoppingState extends State {
	
	private static final long serialVersionUID = 1L;
	
	public int EventId, shopId;
	public BufferedImage window, windowClear;
	public TreeMap<Item, Integer> selection = new TreeMap<>();
	public int currentchoice, choicelocation,firstchoice, boxsize;
	public int amount;
	public Item[] itemDisplay;
	public boolean selected,exit;
	public BufferedImage shopKeeper;
	public GameState gs;
	public String text;
	
	//KeyListener delay variables.
	private int delayCursor = 120;
	private int delaySelection = 200;
	
	public ShoppingState(Game game, GameState gs, StateManager sm, int eventId,TreeMap<Item, Integer> choices,
			BufferedImage sk, int shopId){
		super(game,sm);
		this.EventId=eventId;
		this.shopId = shopId;
		this.selection=choices;
		this.gs = gs;
		this.shopKeeper = sk;
		currentchoice=0;				//which item is selected
		choicelocation=0;				//where does the item show up on the menu
		firstchoice=0;					//where out of all the options is the list currently looking at
		amount = 0;
		selected=false;					
		exit=false;						//pressed when exiting. back button
		if(selection.size()>8){				//list is 5 items long. Any longer and the list will scroll
			boxsize=8;
		}
		else{
			boxsize=selection.size();
		}

		Set<Item> temp = selection.keySet();
		itemDisplay = temp.toArray(new Item[999]);
		text = gs.getEvents()[eventId].shopOpen();
		window = ImageLoader.loadImage("/ui/Window/WindowBlue2.png");
		windowClear = ImageLoader.loadImage("/ui/Window/WindowClear.png");

	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			//pressing x goes back
			if(game.getKeyManager().x){
				exit=true;
				game.getKeyManager().disable(delayCursor);
			}
			
			//pressing space runs the currently selected option
			if(!selected){
				if(game.getKeyManager().space){
					selected=true;
					game.getKeyManager().disable(delaySelection);
					text = itemDisplay[choicelocation].getDescr();
				}
				
				//up and down choose options
				if(game.getKeyManager().up){
					if(currentchoice>0){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						currentchoice--;
						if(choicelocation==0){
							firstchoice--;
						}
						else{
							choicelocation--;
						}
						game.getKeyManager().disable(delayCursor);
					}
					text = itemDisplay[choicelocation].getDescr();

				}
				if(game.getKeyManager().down){
					if(currentchoice<selection.size()-1){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						currentchoice++;
						if(choicelocation==boxsize-1){
							firstchoice++;
						}
						else{
							choicelocation++;
						}
						game.getKeyManager().disable(delayCursor);
					}
					text = itemDisplay[choicelocation].getDescr();
				}
			}
			else{
				if(game.getKeyManager().space){
					game.getAudiomanager().playSound("/Audio/buy.wav", false);
					gs.scriptChange(-amount*selection.get(itemDisplay[choicelocation]));
					gs.inventorymanager.loot(itemDisplay[choicelocation], amount);
					text = gs.getEvents()[EventId].boughtString(itemDisplay[choicelocation], amount, selection.get(itemDisplay[choicelocation]));
					exit = true;
					game.getKeyManager().disable(delaySelection);
					
					//Shop benefits?
					switch(shopId){
					//Janitor
					case 0:
						break;
					//Vending Machines
					case 1:
						break;
					//Aquarium Gift Shop
					case 2:
						break;
					//Angry's
					case 3:
						break;
					//Doggin' Dave's
					case 4:
						break;
					//Phlegmings
					case 5:
						break;
					//Tunzo Funn's
					case 6:
						break;
					//Juice
					case 7:
						break;
					//Red Jujube
					case 8:
						break;
					//Sauce
					case 9:
						break;
					//Svente's
					case 10:
						break;
					//______'s Garden
					case 11:
						break;
					}
				}
				
				//up and down choose options
				if(game.getKeyManager().up){
					if((amount+1)*selection.get(itemDisplay[choicelocation])<=gs.Script){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						amount++;
						game.getKeyManager().disable(delayCursor);
					}
					
				}
				if(game.getKeyManager().down){
					if(amount>0){
						game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
						amount--;
						game.getKeyManager().disable(delayCursor);
					}
				}
			}
		}		
	}
			

	public void render(Graphics g) {
		
		//ChoiceBranches do not take up the entire screen. The state underneath it should be rendered as well
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
		//if x is pressed, the state is popped
		if(exit==true){
			if(selected){
				selected = false;
				amount = 0;
				exit = false;
			}
			else{
				StateManager.getStates().pop();
				exit=false;
			}
			
		}
		
		g.drawImage(shopKeeper, 0, 416-shopKeeper.getHeight(), null);

		String[] options = new String[selection.size()];
		for(int i = 0; i < options.length; i++){
			options[i] = selection.keySet().toArray(new Item[selection.size()])[i].getName();
		}
		
		Item curItem = itemDisplay[choicelocation];
		
		Utils.drawMenu(g, window, options, Color.black, 12, new Font("Courier", Font.PLAIN, 18),choicelocation, 300, 5, 340, 30*boxsize, 1,boxsize,firstchoice,16, true,true);
		Utils.drawDialogueBox(g, window, "Script: "+gs.Script, 12, Color.black, 15, 5, 100, 50, 16, true);
		for(int i=0;i<boxsize;i++){
			g.drawString(selection.get(itemDisplay[firstchoice+i])+" Script", 550,40+25*i);
		}
		Utils.drawDialogueBox(g, window, text, 18, Color.black, 0, 316, 625, 80, 16, true);

		Utils.drawDialogueBox(g, window, "", 16, Color.black, 160, 5, 128, 128, 16, true);

		Utils.drawDialogueBox(g, window, curItem.getDescrShort(gs), 12, Color.black, 360, 220, 260, 80, 16, true);

		g.drawImage(curItem.getIcon(), 160, 5, null);
		
		
		
		if(selected){
			g.setColor(new Color(102, 178,255, 200));
			g.fillRect(180, 200, 275, 50);
			g.setFont(new Font("Chewy", Font.PLAIN, 18));
			g.setColor(new Color(0,0,0));
			g.drawString(itemDisplay[choicelocation].getName()+" x "+amount+" :",185,225);
			g.drawString(amount*selection.get(itemDisplay[choicelocation])+" Script",400, 225);
			if(amount>0){
				g.drawImage(Assets.Downarrow,300,255,null);
			}
			if((amount+1)*selection.get(itemDisplay[choicelocation])<=gs.Script){
				g.drawImage(Assets.Uparrow,300,180,null);
			}
		}

	}

	@Override
	public void init() {
		
	}
	

}
