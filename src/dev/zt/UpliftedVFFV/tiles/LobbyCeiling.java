package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class LobbyCeiling extends Tile {
	public final static int id = 22;
	public final static BufferedImage texture = Assets.LobbyCeiling;
	
	public LobbyCeiling() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
