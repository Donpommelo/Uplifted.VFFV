package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StairsLeft extends Tile {
	
	public final static int id = 21;
	public final static BufferedImage texture = Assets.White;
	
	public StairsLeft() {
		super(texture, id);
	}

	public boolean isWall(){
		return true;
	}
	
	public int isDiagMove(){
		return -1;
	}
}
