package dev.zt.UpliftedVFFV.states;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.PostageStamp;
import dev.zt.UpliftedVFFV.utils.Utils;

//PenPal State. This state controls letters sent to your Pen Pal.
public class PenPalLetterState extends State {
	
	private boolean writing, exit;
	private BufferedImage window;
	private GameState gamestate;
	private AudioManager audio;

	private int optionSelected;
	
	private String prompt;
	
	public PenPalLetterState(Game game, StateManager sm){
		super(game,sm);
		writing = false;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		audio = game.getAudiomanager();
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
		optionSelected = 0;
		prompt = "";
	}

	public void tick() {
		
		if(game.getKeyManager().x){
			audio.playSound("/Audio/ui_upgrade_ability_01.wav", false);
			exit=true;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(!writing){
			if(game.getKeyManager().space){
				audio.playSound("/Audio/paper_pickup_01.wav", false);
				writing=true;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(game.getKeyManager().left){
				if(optionSelected>0){
					audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
					optionSelected--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(game.getKeyManager().right){
				if(optionSelected<1){			
					audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
					optionSelected++;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else{
			
		}
		

	}
			
	
	public void render(Graphics g) {
		if(!exit){
			if(writing){
				writing = false;
			}
			else{
				StateManager.getStates().pop();
			}
		}
		
		if(!writing){
			String[] options = {"Yes","No"};
			g.setColor(Color.black);
			g.setFont(new Font("Chewy", Font.PLAIN, 12));
			g.drawString("Write a letter to your Pen Pal?",200,160);
			g.drawString(gamestate.inventorymanager.backpack.get(new PostageStamp())+" Postage Stamp(s) left", 200,200);
			Utils.drawMenu(g, window, options, Color.black, 25, optionSelected, 5, 5, 125, 380, true);
		}
		else{
			
		}

		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
	}

	@Override
	public void init() {
		
	}
	

}
