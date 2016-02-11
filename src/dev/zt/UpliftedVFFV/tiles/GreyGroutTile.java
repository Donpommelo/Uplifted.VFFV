package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GreyGroutTile extends Tile{

	public final static int id = 39;
	public final static BufferedImage texture = Assets.GreyGroutTile;
	
	public GreyGroutTile() {
		super(texture, id);
	}
}
