package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Grass extends Tile{

	public final static int id = 51;
	public final static BufferedImage texture = Assets.Grass;
	
	public Grass() {
		super(texture, id);
	}
}
