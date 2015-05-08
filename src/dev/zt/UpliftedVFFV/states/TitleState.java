package dev.zt.UpliftedVFFV.states;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;

//First state ran. This is a title screen
public class TitleState extends State {
	
	private BufferedImage testImage;
	private boolean updown, button;
	private StateManager statemanager;
	
	public TitleState(Game game, StateManager sm){
		super(game,sm);
		testImage = ImageLoader.loadImage("/textures/title.png");
		button=false;
		updown=true;
	}

	//receives input command to either begin or exit the game
	public void tick() {
		if(game.getKeyManager().left){
			updown=true;
		}
		if(game.getKeyManager().right){
			updown=false;
		}
		if(game.getKeyManager().space){
			button=true;
		}
		
	}


	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 640, 416);
		g.drawImage(testImage, 48, 0, null);
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		if(updown==true){
			g.fillOval(118, 83, 20, 20);
			g.drawString("PLAY", 424, 375);
		}
		if(updown==false){
			g.fillOval(232, 83, 20, 20);
			g.drawString("EXIT", 424, 375);
		}
		if(button==true){
			if(updown==true){
				StateManager.states.push(new GameState(game,statemanager));		//This pushes on a gamestate. The game begins.
			}
			if(updown==false){
				System.exit(0);													//this exits the game
			}
		}
	}

	@Override
	public void init() {
		
	}
	

}
