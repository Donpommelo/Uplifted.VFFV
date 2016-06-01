package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GreyWalls extends Tile {
	
	public final static int id = 35;
	public final static BufferedImage texture = Assets.GreyWall;
	public GreyWalls() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean isWall(){
		return true;
	}
	
}
