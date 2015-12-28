package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StairsDown extends Tile {
	
	public final static int id = 19;
	public final static BufferedImage texture = Assets.StairsDown;
	
	public StairsDown() {
		super(texture, id);
	}
	
	public boolean isWall(){
		return true;
	}
	
}
