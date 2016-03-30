package dev.zt.UpliftedVFFV.states;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.PenPalLetters.Letter;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//PenPal State. This state controls letters sent to your Pen Pal.
public class PenPalLetterState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private int mode;
	private String[] received;
/*
 0: Typing
 1: Revising/Sending Option
 2: Looking at Old Letter
 3: Reading a Letter
 */
	
	private BufferedImage window, window2;
	private AudioManager audio;
	private StringBuilder prompt;
	private Game game;
	private GameState gs;
	private StateManager sm;
	private String reply = "";
	//Pointer for menu that pops up when letter is ready to send.
	private int sendPointer, letterSelected,pointerLocation;
	private int maxLetters = 14;
	private int maxHeight;
	int y;
	//Variable for displaying flashing cursor.
	private int flashCounter;
	private boolean flash;
	
	private int delayNext = 200;
	
	public PenPalLetterState(Game game, GameState gs, StateManager sm){
		super(game,sm);
		this.game = game;
		this.gs = gs;
		this.sm = sm;
		window = ImageLoader.loadImage("/ui/Window/WindowYellowPaper.png");
		window2 = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		audio = game.getAudiomanager();
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
		prompt = new StringBuilder(20);
		game.getKeyManager().setTypeMode(true);
		mode = 0;
		sendPointer = 0;
		letterSelected = 0;
		pointerLocation = 0;
		flashCounter = 0;
		flash = false;
		y = 0;
		maxHeight = 0;
	}

	public void tick() {
		if(game.getKeyManager().isActive()){
			switch(mode){
			case 0:
				String key = game.getKeyManager().getKeyTyped();
				if(!key.equals("")){
					if(key.equals("Backspace")){
						if(prompt.length() > 0){
							prompt.deleteCharAt(prompt.length() - 1);
						}
						game.getKeyManager().disable(125);
					}
					else if(key.equals("Enter")){
						game.getKeyManager().setTypeMode(false);
						game.getKeyManager().disable(delayNext);
						sendPointer = 0;
						mode = 1;
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
						game.getKeyManager().disable(125);
					} else if(key.equals("Space")){
						audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
						if(prompt.length() < 20){
							prompt.append(" ");
						}
						game.getKeyManager().disable(125);
					}
				}
				break;
			case 1:
				if(game.getKeyManager().space){
					switch(sendPointer){
						case 0:
							//Send.
							mode = 3;
							reply = findText(prompt.toString());
							y = 0;
							break;
						case 1:
							//Revise.
							mode = 0;
							game.getKeyManager().setTypeMode(true);
							break;
							
						case 2:
							//Read old mail
							sendPointer = 0;
							mode = 2;
							break;
						case 3:
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
					if(sendPointer < 3){
						sendPointer++;
					}
					game.getKeyManager().disable(delayNext);
				}
				break;
			case 2:
				if(!Letter.received.isEmpty()){
					received= new String[Letter.received.size()];
					for(int i = 0; i <Letter.received.size(); i++){
						received[i] = Letter.received.get(i).getPrompts()[0];
					}
				}
				else{
					received= new String[1];
					received[0] = "You don't have any mail!";
				}
				if(game.getKeyManager().space){
					if(!Letter.received.isEmpty()){
						reply = Letter.received.get(sendPointer).getLetter();
						mode = 3;
						y = 0;
					}
					else{
						game.getKeyManager().setTypeMode(true);
						mode = 0;
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().up){
					if(letterSelected > 0){
						letterSelected--;
						if(sendPointer == 0){
							pointerLocation--;
						}
						else{
							sendPointer--;
						}
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().down){
					if(letterSelected < received.length-1){
						letterSelected++;
						if(sendPointer >= maxLetters - 1){
							pointerLocation++;
						}
						else{
							sendPointer++;
						}
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().x){
					game.getKeyManager().setTypeMode(true);
					mode = 0;
					game.getKeyManager().disable(delayNext);
				}
				break;
			case 3:
				if(game.getKeyManager().space || game.getKeyManager().x){
					game.getKeyManager().setTypeMode(true);
					mode = 0;
					game.getKeyManager().disable(delayNext);
				}
				if(game.getKeyManager().down){
					if(y>-maxHeight){
						y-=3;
					}
				}
				if(game.getKeyManager().up){
					if(y<0){
						y+=3;
					}
				}
				break;
			}
		}
	}
			
	public void render(Graphics g) {		
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		switch(mode){
		case 0:
			Utils.drawDialogueBox(g, window, "Dear Pen Pal:", 18, Color.black, 125, 5, 400, 400, 32, true);
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
			break;
		case 1:
			Utils.drawDialogueBox(g, window, "Dear Pen Pal:", 18, Color.black, 125, 5, 400, 400, 32, true);
			g.drawString("Could you tell me about " + prompt.toString() + "?", 150, 85);
			String finishedOptions[] = {"Send!", "Revise", "Read Old Letters","Nevermind"};
			Utils.drawMenu(g, window2, finishedOptions, Color.black, 18, new Font("Courier", Font.PLAIN, 18), sendPointer, 250, 200, 150, 120, true);
			break;
		case 2:
			if(received != null){
				Utils.drawDialogueBox(g, window, "Old Mail", 18, Color.black, 125, 5, 400, 400, 32, true);
				Utils.drawMenu(g, window, received, Color.black, 18, new Font("Courier", Font.PLAIN, 18),sendPointer, 125, 5, 400, 400, 1,maxLetters,pointerLocation,16,true,true);
			}
			break;
		case 3:
			maxHeight = Utils.drawDialogueBox(g, window, reply, 18, Color.black, 125, 5+y, 400, 1000, 32, true);
			break;
		}
	}

	public String findText(String prompt){
		return Letter.checkPrompt(prompt, game, sm, gs).getLetter();
	}
	
	@Override
	public void init() {
		
	}
}
