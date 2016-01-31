package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlackWalls extends Tile {
	
	public final static int id = 31;
	public final static BufferedImage texture = Assets.BlackWall;
	public BlackWalls() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean isWall(){
		return true;
	}
	
}
