package dev.zt.UpliftedVFFV.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;


public class MenuState extends State {
	
	private BufferedImage testImage;
	private boolean fackoff=false;
	StateManager statemanager;
	
	public MenuState(Game game, StateManager sm){
		super(game, sm);
		testImage = ImageLoader.loadImage("/textures/MenuTemp.png");
	}

	public void tick() {
		if(game.getKeyManager().space){
			fackoff=true;
		}
		
	}


	public void render(Graphics g) {
		g.drawImage(testImage, 0, 0, null);
		if(fackoff){
			statemanager.states.pop();
			fackoff=false;
//			StateManager.states.push(new DialogState(game,statemanager,0,2));
		}
		
	}

	@Override
	public void init() {
		
	}
	

}
