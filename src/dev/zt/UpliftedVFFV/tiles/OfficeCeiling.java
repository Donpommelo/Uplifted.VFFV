package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class OfficeCeiling extends Tile {
	public final static int id = 16;
	public final static BufferedImage texture = Assets.OfficeCeiling;
	
	public OfficeCeiling() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
