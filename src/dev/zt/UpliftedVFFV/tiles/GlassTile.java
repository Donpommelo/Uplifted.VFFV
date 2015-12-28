package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GlassTile extends Tile{

	public final static int id = 24;
	public final static BufferedImage texture = Assets.GlassTile;
	
	public GlassTile() {
		super(texture, id);
	}
}
