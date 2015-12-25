package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class WoodBoard extends Tile{
	
	public final static int id = 2;
	public final static BufferedImage texture = Assets.WoodBoard;
	
	public WoodBoard() {
		super(texture, id);
	}
	
}
