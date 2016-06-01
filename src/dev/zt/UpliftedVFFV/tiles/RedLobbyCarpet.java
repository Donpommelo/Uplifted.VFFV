package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class RedLobbyCarpet extends Tile{

	public final static int id = 4;
	public final static BufferedImage texture = Assets.RedCarpet;
	
	public RedLobbyCarpet() {
		super(texture, id);
	}
}
