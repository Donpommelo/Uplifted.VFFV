package dev.zt.UpliftedVFFV.states;
//import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
//import java.awt.image.BufferedImage;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Set;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
//import dev.zt.UpliftedVFFV.audio.AudioManager;
//import dev.zt.UpliftedVFFV.gfx.ImageLoader;
//import dev.zt.UpliftedVFFV.inventory.keyitems.SummonConch;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.utils.Utils;
//import dev.zt.UpliftedVFFV.utils.Utils;

//PenPal State. This state controls letters sent to your Pen Pal.
public class SummoningState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private int mode;

/*
 0: Selecting Summoning Object
 1: Selecting Summoning Ingredient
 2: Confirming choice
 3: Finalizing pact
 */
	private AudioManager audio;
	Set<Item> temp1,temp2;
	private BufferedImage window;
	private ArrayList <Item> summonObjects;
	private ArrayList <Item> summonSauces;
	private Item summonsauce;
	
	private Schmuck summon;
	private GameState gs;
//	private StateManager sm;
	
	//Index of summoning object is selected.
	private int summoner;
	
	//For selecting stuff
	private int itemSelected, itemPointer, frameLocation;
	private boolean exit;
	private int yesno;
	
	//For input delay
	private int delayCursor = 120;
	private int delayNext = 200;

	//for animations
	private double origX, origY, picX,picY,frame;
	
	
	public SummoningState(Game game, GameState gs, StateManager sm, Schmuck Summon){
		super(game,sm);
		this.game = game;
		audio = game.getAudiomanager();

		this.gs = gs;
		this.summon = Summon;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");

		mode = 0;
		
		itemSelected = 0;
		itemPointer = 0;
		frameLocation = 0;
		yesno = 0;
		frame = 0;
		
		temp1 = gs.inventorymanager.backpack.keySet();
		summonObjects = new ArrayList<Item>();
		for(Item item : temp1.toArray(new Item[10])){
			if(item != null && item.isSummonObject()){
				summonObjects.add(item);
			}
		}
		temp2 = gs.inventorymanager.backpack.keySet();
		summonSauces = new ArrayList<Item>();
		for(Item item : temp2.toArray(new Item[10])){
			if(item != null && item.isSummonSauce()){
				summonSauces.add(item);
			}
		}

	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			if(game.getKeyManager().x){
				exit = true;
				game.getKeyManager().disable(delayNext);
			}
			if(gs.getSwitch(10)){//later display message before discovering summoning
				if(game.getKeyManager().space || game.getKeyManager().x){
					StateManager.getStates().pop();
					game.getKeyManager().disable(delayNext);
				}
			}
			else{
				switch(mode){
				case 0:
					if(game.getKeyManager().left){
						if(summoner>0){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							summoner--;
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().right){
						if(summoner < summonObjects.size()-1){			
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							summoner++;
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().space){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						mode = 1;
						frame = 0;
						picX = 5+150*summoner;
						picY = 180;
						origX = 5+150*summoner;
						origY = 180;
						game.getKeyManager().disable(delayNext);
					}
					break;
				case 1:
					if(game.getKeyManager().down){
						if(itemSelected < summonSauces.size() - 1){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemSelected++;
							if(itemPointer == 6){
								frameLocation++;
							} else {
								itemPointer++;
							}
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().up){
						if(itemSelected > 0){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							itemSelected--;
							if(itemPointer == 0){
								frameLocation--;
							} else {
								itemPointer--;
							}
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().space){
						if(!summonSauces.isEmpty()){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							summonsauce = summonSauces.get(itemSelected);
							mode = 2;
							game.getKeyManager().disable(delayNext);
						}
					}
					break;
				case 2:
					if(game.getKeyManager().left){
						yesno = 0;
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						game.getKeyManager().disable(delayCursor);
					}
					if(game.getKeyManager().right){
						yesno = 1;
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						game.getKeyManager().disable(delayCursor);
					}
					if(game.getKeyManager().space){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						summonsauce = summonSauces.get(itemSelected);
						mode = 3;
						game.getKeyManager().disable(delayNext);
					}
					break;
				case 3:
					
					break;
				}
			}	
		}
	}
			
	public void render(Graphics g) {		
		if(exit){
			if(game.getKeyManager().isActive()){
				if(mode == 0){
					StateManager.getStates().pop();
					exit = false;
				}
				if(mode == 1){
					mode = 0;
					game.getKeyManager().disable(delayNext);
					exit = false;
				}
				if(mode == 2){
					mode = 1;
					game.getKeyManager().disable(delayNext);
					exit = false;
				}
			}
		}
		if(gs.getSwitch(10)){
			
			
		}
		else{
			switch(mode){
			
			case 0:
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.drawString("Summon With?", 200, 25);
				for(int i = 0; i <summonObjects.size(); i++){
					Utils.drawDialogueBox(g, window, summonObjects.get(i).getName(), 12, Color.black, 5+150*i, 100, 125, 80, 16, true);
					g.drawImage(summonObjects.get(i).getIcon(),5+150*i, 180, null);
					if(summonObjects.get(i).getSummon() != null){
						g.setFont(new Font("Chewy", Font.PLAIN, 12));
						g.drawString("Current Summon: "+summonObjects.get(i).getSummon().getName(), 5+150*i, 210);
						g.drawImage(summonObjects.get(i).getSummon().getMenuSprite(), 5+150*i, 180, 80,120, null);
					}
					else{
						g.setFont(new Font("Chewy", Font.PLAIN, 12));
						g.drawString("No Current Summon", 5+150*i, 210);
					}
				}
				g.drawImage(Assets.Downarrow, 60+150*summoner,  90, null);
				break;
			case 1:
				if(frame < 60){
					frame++;
					picX -= (origX-15)/60;
					picY -= (origY-15)/60;
				}
				g.drawImage(summonObjects.get(summoner).getIcon(),(int)picX,(int)picY, null);
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				g.drawString("Summoning With: "+summonObjects.get(summoner).getName(), 25, 15);
				
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.drawString("Select Summoning Sauce", 280, 25);
				String[] sauces = new String[summonSauces.size()];
				for(int i = 0; i < summonSauces.size(); i++){
					sauces[i] = summonSauces.get(i).getName();
				}
				Utils.drawMenu(g, window, sauces , Color.black, 15, new Font("Courier", Font.PLAIN, 15),itemPointer, 260, 48, 180, 200, 1, 5, 
						frameLocation, 16, true,true);
				break;
			case 2:
				g.setFont(new Font("Chewy", Font.PLAIN, 12));
				g.drawString("Summoning With: "+summonObjects.get(summoner).getName(), 25, 100);
				g.drawImage(summonObjects.get(summoner).getIcon(),15,15, null);
				
				String[] options = {"Yes", "No"};
				Utils.drawMenu(g, window, options , Color.black, 15, new Font("Courier", Font.PLAIN, 15),yesno, 400, 300, 200, 64, 2, 1, 
						0, 16, true,true);
				break;
			case 3:
				if(yesno == 0){
					gs.getPartymanager().recruit(summon);
					if(summonObjects.get(summoner).getSummon() != null){
						summonObjects.get(summoner).setXp(summonObjects.get(summoner).getSummon().exp);
						gs.getPartymanager().unrecruit(summonObjects.get(summoner).getSummon());
					}
					summon.expGain(summonObjects.get(summoner).getXp());
					summonsauce.summonBonus(summon);
					gs.inventorymanager.use(summonsauce);
					summonObjects.get(summoner).setSummon(summon);
				}
				if(game.getKeyManager().space || game.getKeyManager().x){
					StateManager.getStates().pop();
					game.getKeyManager().disable(delayNext);
				}
				break;
			}
			g.setFont(new Font("Chewy", Font.PLAIN, 12));
			g.drawString("Summon this Ally? : "+ summon.getName(), 500, 15);
			g.drawImage(summon.getMenuSprite(), 500, 15,80,120, null);
		}
		
	}

	
	@Override
	public void init() {
		
	}
}
