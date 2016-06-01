package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GreyCeiling extends Tile {
	public final static int id = 34;
	public final static BufferedImage texture = Assets.GreyCeiling;
	
	public GreyCeiling() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
