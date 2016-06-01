package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlackCeiling extends Tile {
	public final static int id = 30;
	public final static BufferedImage texture = Assets.BlackCeiling;
	
	public BlackCeiling() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
