package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class PaleMarble extends Tile{

	public final static int id = 47;
	public final static BufferedImage texture = Assets.PaleMarble;
	
	public PaleMarble() {
		super(texture, id);
	}
}
