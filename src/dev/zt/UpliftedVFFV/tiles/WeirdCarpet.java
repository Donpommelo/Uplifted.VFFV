package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class WeirdCarpet extends Tile{

	public final static int id = 46;
	public final static BufferedImage texture = Assets.WeirdCarpet;
	
	public WeirdCarpet() {
		super(texture, id);
	}
}
