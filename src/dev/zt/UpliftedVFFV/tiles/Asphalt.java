package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Asphalt extends Tile{

	public final static int id = 44;
	public final static BufferedImage texture = Assets.Asphalt;
	
	public Asphalt() {
		super(texture, id);
	}
}
