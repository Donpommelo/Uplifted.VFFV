package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class AquariumCeiling extends Tile {
	public final static int id = 32;
	public final static BufferedImage texture = Assets.AquariumCeiling;
	
	public AquariumCeiling() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
