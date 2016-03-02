package dev.zt.UpliftedVFFV.Battle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class BattleBackground {
	
	//BattleBackground manages the background of battle. An simple job, but someone has to do it.
	
	//floor and wall: The two components of the background
	private BufferedImage floor, wall;
	
	//sm, game, bs : Not used right now, but could be useful later if we ever want backgrounds to be more dynamic
	//We probably won't.
	public StateManager sm;
	public Game game;
	public BattleState bs;
	
	public BattleBackground(Game game, StateManager sm, BattleState bs){
		this.game = game;
		this.sm = sm;
		this.bs = bs;	
		floor = ImageLoader.loadImage("/Backgrounds/OfficeFloor.png");
		wall = ImageLoader.loadImage("/Backgrounds/OfficeWall.png");
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(floor, 0, 0,null);
		g.drawImage(wall, 0, -32, null);
	}

}
