package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class VoidTile extends Tile {

	public final static int id = 1;
	public final static BufferedImage texture = Assets.Void;
	
	public VoidTile() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
