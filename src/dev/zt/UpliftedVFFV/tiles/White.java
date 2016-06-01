package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class White extends Tile{

	public final static int id = 42;
	public final static BufferedImage texture = Assets.White;
	
	public White() {
		super(texture, id);
	}
}
