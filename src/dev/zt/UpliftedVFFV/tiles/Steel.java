package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Steel extends Tile{

	public final static int id = 43;
	public final static BufferedImage texture = Assets.Steel;
	
	public Steel() {
		super(texture, id);
	}
}
