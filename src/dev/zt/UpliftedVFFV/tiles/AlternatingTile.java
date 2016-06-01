package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class AlternatingTile extends Tile{

	public final static int id = 48;
	public final static BufferedImage texture = Assets.AlternatingTile;
	
	public AlternatingTile() {
		super(texture, id);
	}
}
