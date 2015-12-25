package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class WhiteCarpet extends Tile{

	public final static int id = 15;
	public final static BufferedImage texture = Assets.WhiteCarpet;
	
	public WhiteCarpet() {
		super(texture, id);
	}
}
