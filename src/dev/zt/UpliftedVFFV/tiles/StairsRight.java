package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StairsRight extends Tile {
	
	public final static int id = 20;
	public final static BufferedImage texture = Assets.White;
	
	public StairsRight() {
		super(texture, id);
	}

	public boolean isWall(){
		return true;
	}
	
	public int isDiagMove(){
		return 1;
	}
}
