package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.events.Event;


//A state that displays an image and allows the player to use arrow keys to move it around, examining it.
public class ExamineState extends State{
		
	private AudioManager audio;
	private int width, height;
	private int x,y;
	private BufferedImage image;
	private int EventId;
	
	public ExamineState(Game game, StateManager sm, BufferedImage i, int eventID){
		super(game, sm);
		audio = game.getAudiomanager();
		EventId = eventID;
		this.image = i;
		this.width = i.getWidth();
		this.height = i.getHeight();
		this.x = 0;
		this.y = 0;
	}

	@Override
	public void tick() {
		if(game.getKeyManager().isActive()){
			if(game.getKeyManager().space || game.getKeyManager().x){
				audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
				StateManager.getStates().pop();
				game.getKeyManager().disable(200);
				if(Event.events[this.EventId].getstage()!=Event.events[this.EventId].getfinalstage()){
					Event.events[this.EventId].setstage(Event.events[this.EventId].getstage()+1);
					Event.events[this.EventId].run();
				}
				
			}
			if(game.getKeyManager().left){
				if(x>0){
					x-=5;
				}
			}
			if(game.getKeyManager().right){
				if(x<640-width){
					x+=5;
				}
			}
			if(game.getKeyManager().up){
				if(y>0){
					y-=5;
				}
			}
			if(game.getKeyManager().down){
				if(y<416-height){
					y+=5;
				}
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		StateManager.getStates().push(this);
		g.drawImage(image, x, y, null);
	}

	@Override
	public void init() {
		//lol also does nothing			
	}

		
}
