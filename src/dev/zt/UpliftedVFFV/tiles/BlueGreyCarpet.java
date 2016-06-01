package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlueGreyCarpet extends Tile{

	public final static int id = 45;
	public final static BufferedImage texture = Assets.BlueGreyCarpet;
	
	public BlueGreyCarpet() {
		super(texture, id);
	}
}
