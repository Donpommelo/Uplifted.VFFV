package dev.zt.UpliftedVFFV.states;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//PenPal State. This state controls letters sent to your Pen Pal.
public class TypingState extends State {
	
	private static final long serialVersionUID = 1L;
	
	private int mode;
/*
 0: Typing
 1: Finalizing/Revising
 */
	
	private BufferedImage window;
	private AudioManager audio;
	private StringBuilder prompt;
	private Game game;
	private GameState gs;
	private String reply = "";
	private String intro;
	//Pointer for menu that pops up when letter is ready to send.
	private int maxLetters;
	//Variable for displaying flashing cursor.
	private int flashCounter;
	private int sendPointer;
	private boolean flash;
	
	private int delayNext = 150;
	private int EventId;
	
	public TypingState(Game game, GameState gs, StateManager sm, String text,int max, int Id){
		super(game,sm);
		this.game = game;
		this.gs = gs;
		window = ImageLoader.loadImage("/ui/Window/WindowBlue.png");
		audio = game.getAudiomanager();
		game.getAudiomanager().playSound("/Audio/tutorial_ui_click_01.wav", false);
		prompt = new StringBuilder(20);
		game.getKeyManager().setTypeMode(true);
		mode = 0;
		flashCounter = 0;
		sendPointer = 0;
		flash = false;
		intro = text;
		maxLetters = max;
		EventId = Id;
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
						game.getKeyManager().disable(delayNext);
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
						if(prompt.length() < maxLetters){
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
						game.getKeyManager().disable(delayNext);
					}
				}
				break;
			case 1:
				if(game.getKeyManager().space){
					switch(sendPointer){
						case 0:
							//Yes.
							mode = 3;
							reply = prompt.toString();
							StateManager.getStates().pop();
							if(gs.getEvents()[EventId].getstage()!=gs.getEvents()[EventId].getfinalstage()){
								gs.getEvents()[EventId].textMade(reply);
							}
						break;
						case 1:
							//No.
							mode = 0;
							game.getKeyManager().setTypeMode(true);
							break;
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().up){
					if(sendPointer > 0){
						sendPointer--;
					}
					game.getKeyManager().disable(delayNext);
				} else if(game.getKeyManager().down){
					if(sendPointer < 1){
						sendPointer++;
					}
					game.getKeyManager().disable(delayNext);
				}
				break;
			}
		}
	}
			
	public void render(Graphics g) {		
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		
		Utils.drawDialogueBox(g, window, intro, 18, Color.black, 125, 5, 400, 400, 32, true);
		g.drawString(prompt.toString(), 150, 85);
		
		switch(mode){
		case 0:
			if(flash){
				g.drawString("__", 150 + g.getFontMetrics().stringWidth(prompt.toString()), 85);
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
			String finishedOptions[] = {"Ok, Done!", "Wait, nevermind!"};
			Utils.drawMenu(g, window, finishedOptions, Color.black, 18, new Font("Courier", Font.PLAIN, 18), sendPointer, 250, 200, 150, 120, true);
			break;
		}
	}
	
	@Override
	public void init() {
		
	}
}
