package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.audio.AudioManager;
import dev.zt.UpliftedVFFV.gfx.Assets;


//A state that displays an image and allows the player to use arrow keys to move it around, examining it.
public class ExamineState extends State{
		
	private AudioManager audio;
	private int width, height;
	private int x,y;
	private BufferedImage image;
	private int EventId;
	private GameState gs;
	
	public ExamineState(Game game, GameState gs, StateManager sm, BufferedImage i, int eventID){
		super(game, sm);
		this.gs = gs;
		audio = game.getAudiomanager();
		EventId = eventID;
		this.image = i;
		this.width = i.getWidth();
		this.height = i.getHeight();
		if(width<640){
			this.x = 320-width/2;
		}
		else{
			this.x = 0;
		}
		if(height<416){
			this.y = 208-height/2;
		}
		else{
			this.y = 0;
		}
	}

	@Override
	public void tick() {
		if(game.getKeyManager().isActive()){
			if(game.getKeyManager().space || game.getKeyManager().x){
				audio.playSound("/Audio/tutorial_ui_click_01.wav", false);
				StateManager.getStates().pop();
				game.getKeyManager().disable(200);
				if(gs.getEvents()[this.EventId].getstage()!=gs.getEvents()[this.EventId].getfinalstage()){
					gs.getEvents()[this.EventId].setstage(gs.getEvents()[this.EventId].getstage()+1);
					gs.getEvents()[this.EventId].run();
				}
				
			}
			if(game.getKeyManager().right){
				if(x+width>640){
					x-=3;
				}
			}
			if(game.getKeyManager().left){
				if(x<0){
					x+=3;
				}
			}
			if(game.getKeyManager().down){
				if(y+height>416){
					y-=3;
				}
			}
			if(game.getKeyManager().up){
				if(y<0){
					y+=3;
				}
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		StateManager.getStates().pop();
		StateManager.getStates().peek().render(g);
		g.drawImage(Assets.DarkFilter,0,0,null);
		StateManager.getStates().push(this);
		g.drawImage(image, x, y, null);
		if(y+height>416){
			g.drawImage(Assets.Downarrow, 315, 390, null);
		}
		if(y<0){
			g.drawImage(Assets.Uparrow, 315, 0, null);
		}
	}

	@Override
	public void init() {
		//lol also does nothing			
	}

		
}
