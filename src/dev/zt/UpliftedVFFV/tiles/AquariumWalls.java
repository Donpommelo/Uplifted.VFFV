package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class AquariumWalls extends Tile {
	
	public final static int id = 33;
	public final static BufferedImage texture = Assets.AquariumWall;
	public AquariumWalls() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean isWall(){
		return true;
	}
	
}
