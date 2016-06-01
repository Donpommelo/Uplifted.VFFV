package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class RedElevator extends Tile{

	public final static int id = 54;
	public final static BufferedImage texture = Assets.RedElevator;
	
	public RedElevator() {
		super(texture, id);
	}
}
