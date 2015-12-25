package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Black extends Tile{

	public final static int id = 0;
	public final static BufferedImage texture = Assets.Black;
	
	public Black() {
		super(texture, id);
	}
}
