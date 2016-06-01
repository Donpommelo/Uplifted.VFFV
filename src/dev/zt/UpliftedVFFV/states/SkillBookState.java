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
import dev.zt.UpliftedVFFV.ablities.Skills;
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
public class SkillBookState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private int mode;

/*
 0: Selecting Schmuck
 1: Selecting VCR
 2: Confirming choice
 */
	private AudioManager audio;
	Set<Item> temp1,temp2;
	private BufferedImage window;
	private ArrayList <Item> skillBooks;
	
	private GameState gs;
//	private StateManager sm;
	
	//Index of summoning object is selected.
	private int vcr;
	
	//For selecting stuff
	private int characterSelected, characterPointer;
	private boolean exit;
	private int yesno;
	
	//For input delay
	private int delayCursor = 120;
	private int delayNext = 200;

	
	
	public SkillBookState(Game game, GameState gs, StateManager sm, Schmuck Summon){
		super(game,sm);
		this.game = game;
		audio = game.getAudiomanager();

		this.gs = gs;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");

		mode = 0;
		
		characterSelected = 0;
		characterPointer = 0;
		yesno = 0;
		
		temp1 = gs.inventorymanager.backpack.keySet();
		skillBooks = new ArrayList<Item>();
		for(Item item : temp1.toArray(new Item[10])){
			if(item != null && item.getVCR() != null){
				skillBooks.add(item);
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
					if(game.getKeyManager().space){
						audio.playSound("/Audio/paper_pickup_01.wav", false);
						mode = 1;
						game.getKeyManager().disable(delayNext);
					}
					if(game.getKeyManager().right){
						if(characterSelected<gs.partymanager.party.size()-1){
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
					break;
				case 1:
					if(game.getKeyManager().left){
						if(vcr>0){
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							vcr--;
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().right){
						if(vcr < skillBooks.size()-1){			
							audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
							vcr++;
							game.getKeyManager().disable(delayCursor);
						}
					}
					if(game.getKeyManager().space){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						mode = 2;
						game.getKeyManager().disable(delayNext);
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
				//Draw character screen.
				Utils.drawDialogueBox(g, window, "", 18, Color.black, 135, 5, 480, 150, 16, true);
				//Draw custom Cursor.
				Utils.drawCursor(g, window, 138 + characterSelected * 100, 14, 100, 128, false);
				for(int i = 0; i < gs.partymanager.party.size(); i++){
					g.drawString(gs.partymanager.party.get(i).getName(), 160 + 100 * i, 30);
					g.drawImage(gs.partymanager.party.get(i).getMenuSprite(), 144 + 100 * i, 15, 94, 141, null);
				}
				break;
			case 1:
				g.setFont(new Font("Chewy", Font.PLAIN, 18));
				g.drawString("What to watch?", 200, 25);
				for(int i = 0; i <skillBooks.size(); i++){
					Utils.drawDialogueBox(g, window, skillBooks.get(i).getName(), 12, Color.black, 5+150*i, 100, 125, 80, 16, true);
					g.drawImage(skillBooks.get(i).getIcon(),5+150*i, 180, null);
					if(skillBooks.get(i).getSummon() != null){
						g.setFont(new Font("Chewy", Font.PLAIN, 12));
						g.drawString("Current Summon: "+skillBooks.get(i).getSummon().getName(), 5+150*i, 210);
						g.drawImage(skillBooks.get(i).getSummon().getMenuSprite(), 5+150*i, 180, 80,120, null);
					}
					else{
						g.setFont(new Font("Chewy", Font.PLAIN, 12));
						g.drawString("You have nothing to watch!", 5+150*i, 210);
					}
				}
				g.drawImage(Assets.Downarrow, 60+150*vcr,  90, null);
				break;
			case 2:
			
				String[] options = {"Yes", "No"};
				Utils.drawMenu(g, window, options , Color.black, 15, new Font("Courier", Font.PLAIN, 15),yesno, 400, 300, 200, 64, 2, 1, 
						0, 16, true,true);
				break;
			case 3:
				if(game.getKeyManager().space || game.getKeyManager().x){
					Skills newSkill = skillBooks.get(vcr).getVCR();
					Schmuck learner = gs.partymanager.party.get(characterSelected);
					if(learner.getLevelSkills().containsKey(newSkill)){
						StateManager.getStates().push(new NotificationState(game, gs, statemanager, "You watch the video, and learn a new ability.", 0));
						learner.learnSkill(newSkill);
						gs.inventorymanager.use(skillBooks.get(vcr));
					}
					else{
						StateManager.getStates().push(new NotificationState(game, gs, statemanager, "You watch the video, but gain nothing from it.", 0));
					}
					StateManager.getStates().pop();
					game.getKeyManager().disable(delayNext);
				}
				break;
			}
		}
	}

	
	@Override
	public void init() {
		
	}
}
