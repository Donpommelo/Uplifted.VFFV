package dev.zt.UpliftedVFFV.states;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//PenPal State. This state controls letters sent to your Pen Pal.
public class PenPalLetterState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private boolean writing, done;
	private BufferedImage window, window2;
	private AudioManager audio;
	private StringBuilder prompt;
	private Game game;
	
	//Pointer for menu that pops up when letter is ready to send.
	private int sendPointer;
	//Variable for displaying flashing cursor.
	private int flashCounter;
	private boolean flash;
	
	private int delayNext = 200;
	
	public PenPalLetterState(Game game, StateManager sm){
		super(game,sm);
		this.game = game;
		done = false;
		window = ImageLoader.loadImage("/ui/Window/WindowYellowPaper.png");
		window2 = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		audio = game.getAudiomanager();
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
		prompt = new StringBuilder(20);
		game.getKeyManager().setTypeMode(true);
		
		writing = false;
		
		sendPointer = 0;
		flashCounter = 0;
		flash = false;
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			if(done){
				if(game.getKeyManager().space){
					switch(sendPointer){
						case 0:
							//Send.
							writing = true;
							break;
						case 1:
							//Revise.
							done = false;
							game.getKeyManager().setTypeMode(true);
							break;
						case 2:
							//Cancel.
							StateManager.getStates().pop();
							break;
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().up){
					if(sendPointer > 0){
						sendPointer--;
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().down){
					if(sendPointer < 2){
						sendPointer++;
					}
					game.getKeyManager().disable(delayNext);
				}
			} else{
				String key = game.getKeyManager().getKeyTyped();
				if(!key.equals("")){
					if(key.equals("Backspace")){
						if(prompt.length() > 0){
							prompt.deleteCharAt(prompt.length() - 1);
						}
						game.getKeyManager().disable(delayNext);
					}
					else if(key.equals("Enter")){
						done = true;
						game.getKeyManager().setTypeMode(false);
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
						if(prompt.length() < 20){
							if(prompt.length() == 0 || (prompt.length() > 1) && prompt.toString().charAt(prompt.length() - 1) == ' '){
								prompt.append(key);
							} else{
								prompt.append(key.toLowerCase());
							}
						}
						game.getKeyManager().disable(delayNext);
					} else if(key.equals("Space")){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						if(prompt.length() < 20){
							prompt.append(" ");
						}
						game.getKeyManager().disable(delayNext);
					}
				}
			}	
		}
	}
			
	public void render(Graphics g) {		
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		if(!writing){
			Utils.drawDialogueBox(g, window, "Dear Pen Pal:", 18, Color.black, 125, 5, 400, 400, 32, true);
			if(done){
				g.drawString("Could you tell me about " + prompt.toString() + "?", 150, 85);
				String finishedOptions[] = {"Send!", "Revise", "Nevermind"};
				Utils.drawMenu(g, window2, finishedOptions, Color.black, 18, sendPointer, 250, 200, 120, 120, true);
			}
			else{
				g.drawString("Could you tell me about " + prompt.toString() + "     ?", 150, 85);
				if(flash){
					g.drawString("__", 150 + g.getFontMetrics().stringWidth("Could you tell me about " + prompt.toString()), 85);
				}
				flashCounter++;
				if(flashCounter % 25 == 0){
					flash = !flash;
				}
				if(flashCounter > 100){
					flashCounter = 0;
				}
			}
		} else{
			findText(prompt.toString());
			StateManager.getStates().pop();
		}
	}

	public String findText(String prompt){
		return "meep";
	}
	
	@Override
	public void init() {
		
	}
}
