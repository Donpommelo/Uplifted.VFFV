package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Brick extends Tile{

	public final static int id = 49;
	public final static BufferedImage texture = Assets.Brick;
	
	public Brick() {
		super(texture, id);
	}
}
