package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class AquaTile extends Tile{

	public final static int id = 6;
	public final static BufferedImage texture = Assets.AquaTile;
	
	public AquaTile() {
		super(texture, id);
	}
}
