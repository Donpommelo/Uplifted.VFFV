package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GreyRowCarpet extends Tile{

	public final static int id = 14;
	public final static BufferedImage texture = Assets.RowCarpet;
	
	public GreyRowCarpet() {
		super(texture, id);
	}
}
