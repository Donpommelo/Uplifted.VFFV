package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlueCarpet extends Tile{

	public final static int id = 5;
	public final static BufferedImage texture = Assets.BlueCarpet;
	
	public BlueCarpet() {
		super(texture, id);
	}
}
