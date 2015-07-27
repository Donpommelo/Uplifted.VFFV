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
	
	private static final long serialVersionUID = 1L;
	
	private boolean writing, exit, done;
	private BufferedImage window;
	private AudioManager audio;
	private String prompt;
	private Game game;
	private int delayNext = 150;
	
	public PenPalLetterState(Game game, StateManager sm){
		super(game,sm);
		this.game = game;
		done = false;
		exit = false;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		audio = game.getAudiomanager();
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
		prompt = "";
		game.getKeyManager().typing = true;
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			if(done){
				if(game.getKeyManager().space){
					exit = true;
					game.getKeyManager().disable(delayNext);
				}
			}
			else{
				String key = game.getKeyManager().keyTyped;
				if(!key.equals("")){
					if(key.equals("Backspace")){
						if(prompt.length()>0){
							prompt = prompt.substring(0, prompt.length()-1);
						}
						game.getKeyManager().disable(delayNext);
					}
					else if(key.equals("ENTER")){
						done = true;
						game.getKeyManager().disable(delayNext);
					}
					else if(key.equalsIgnoreCase("Q") || key.equalsIgnoreCase("W") || key.equalsIgnoreCase("E") || key.equalsIgnoreCase("R")
							|| key.equalsIgnoreCase("T") || key.equalsIgnoreCase("Y") || key.equalsIgnoreCase("U") || key.equalsIgnoreCase("I")
							|| key.equalsIgnoreCase("O") || key.equalsIgnoreCase("P") || key.equalsIgnoreCase("A") || key.equalsIgnoreCase("S")
							|| key.equalsIgnoreCase("D") || key.equalsIgnoreCase("F") || key.equalsIgnoreCase("G") || key.equalsIgnoreCase("H")
							|| key.equalsIgnoreCase("I") || key.equalsIgnoreCase("J") || key.equalsIgnoreCase("K") || key.equalsIgnoreCase("L")
							|| key.equalsIgnoreCase("Z") || key.equalsIgnoreCase("X") || key.equalsIgnoreCase("C") || key.equalsIgnoreCase("V")
							|| key.equalsIgnoreCase("B") || key.equalsIgnoreCase("N") || key.equalsIgnoreCase("M")){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						prompt = prompt.concat(game.getKeyManager().keyTyped);
						game.getKeyManager().disable(delayNext);
					}
				}
			}	
		}
	}
			
	
	public void render(Graphics g) {
		if(exit){
			if(writing){
				writing = false;
			}
			else{
				StateManager.getStates().pop();
			}
		}
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
		if(done){
			
		}
		else{
			g.setColor(Color.red);
			g.setFont(new Font("Chewy", Font.PLAIN, 20));
			g.drawString(prompt,200,160);
		}

		
	}

	public String findText(String prompt){
		return "meep";
	}
	
	@Override
	public void init() {
		
	}
	

}
