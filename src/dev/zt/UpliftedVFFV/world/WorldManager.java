package dev.zt.UpliftedVFFV.world;

import java.awt.Graphics;
import java.io.Serializable;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.states.GameState;

public class WorldManager implements Serializable{
	
	private static final long serialVersionUID = 8L;
	
	public static World world;
	
	//manages world. Very straightforwards
	public WorldManager(Game g){
//		world=new World(g, "/Worlds/SouthElevator.txt");
//		setWorld(world);
	}
		
	public static World getWorld() {
		return GameState.getWorld();
	}

	public static void setWorld(World world) {
		GameState.setWorld(world);
	}
	
	public static void setLoc(int x, int y) {
//		Player.setX(x);
//		Player.setY(y);
	}

	public void tick(){
	}
	
	public void render(Graphics g){
	}
	
	public void init(){
	}

}
