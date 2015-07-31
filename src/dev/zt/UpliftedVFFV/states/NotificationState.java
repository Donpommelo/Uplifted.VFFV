package dev.zt.UpliftedVFFV.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.utils.Utils;

//A simple state that displays a message in the middle of the screen that can be dismissed with a press of a button.
public class NotificationState extends State{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963740710059253953L;
	
	private String myMessage;
	private AudioManager audio;
	private BufferedImage window;
	private int width, height;
	
	public NotificationState(Game game, StateManager sm, String message, int eventID){
		super(game, sm);
		myMessage = message;
		audio = game.getAudiomanager();
		window = ImageLoader.loadImage("/ui/Window/WindowBlack.png");
		width = game.getGraphics().getFontMetrics().stringWidth(message) + 32;
		height = 80;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().isActive()){
			if(game.getKeyManager().space){
				audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
				StateManager.getStates().pop();
			}
		}
	}

	@Override
	public void render(Graphics g) {
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		Utils.drawDialogueBox(g, window, myMessage, 18, Color.white, 320 - width / 2, 208 - height / 2, width, height, 16, true);		
	}

	@Override
	public void init() {
		//lol does nothing
		
	}
		
}
