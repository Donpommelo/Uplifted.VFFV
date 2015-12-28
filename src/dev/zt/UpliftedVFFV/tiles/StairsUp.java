package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StairsUp extends Tile {
	
	public final static int id = 18;
	public final static BufferedImage texture = Assets.StairsUp;
	
	public StairsUp() {
		super(texture, id);
	}
	
	public boolean isWall(){
		return true;
	}
}
