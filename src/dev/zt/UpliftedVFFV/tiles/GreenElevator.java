package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GreenElevator extends Tile{

	public final static int id = 53;
	public final static BufferedImage texture = Assets.GreenElevator;
	
	public GreenElevator() {
		super(texture, id);
	}
}
