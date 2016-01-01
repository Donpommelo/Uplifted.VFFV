package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DarkSandTile extends Tile{

	public final static int id = 29;
	public final static BufferedImage texture = Assets.DarkSandTile;
	
	public DarkSandTile() {
		super(texture, id);
	}
}
