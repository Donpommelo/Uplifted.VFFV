package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class PurpleElevator extends Tile{

	public final static int id = 52;
	public final static BufferedImage texture = Assets.PurpleElevator;
	
	public PurpleElevator() {
		super(texture, id);
	}
}
