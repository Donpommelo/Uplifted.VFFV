package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class WhiteSquareTile extends Tile{

	public final static int id = 3;
	public final static BufferedImage texture = Assets.WhiteTile;
	
	public WhiteSquareTile() {
		super(texture, id);
	}
}
