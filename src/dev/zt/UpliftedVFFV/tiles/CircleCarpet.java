package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class CircleCarpet extends Tile{

	public final static int id = 27;
	public final static BufferedImage texture = Assets.CircleCarpet;
	
	public CircleCarpet() {
		super(texture, id);
	}
}
