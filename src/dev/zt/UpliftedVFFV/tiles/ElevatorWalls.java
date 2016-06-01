package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class ElevatorWalls extends Tile {
	
	public final static int id = 9;
	public final static BufferedImage texture = Assets.ElevatorWalls;
	public ElevatorWalls() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean isWall(){
		return true;
	}
	
}
