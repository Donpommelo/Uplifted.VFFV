package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class YellowCarpet extends Tile{

	public final static int id = 50;
	public final static BufferedImage texture = Assets.YellowCarpet;
	
	public YellowCarpet() {
		super(texture, id);
	}
}
