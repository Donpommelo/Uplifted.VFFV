package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class OfficeWalls extends Tile {
	
	public final static int id = 17;
	public final static BufferedImage texture = Assets.OfficeWalls;
	public OfficeWalls() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
	
	public boolean isWall(){
		return true;
	}
	
}
