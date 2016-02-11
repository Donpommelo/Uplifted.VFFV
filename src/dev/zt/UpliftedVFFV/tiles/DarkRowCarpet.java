package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DarkRowCarpet extends Tile{

	public final static int id = 41;
	public final static BufferedImage texture = Assets.DarkRowCarpet;
	
	public DarkRowCarpet() {
		super(texture, id);
	}
}
