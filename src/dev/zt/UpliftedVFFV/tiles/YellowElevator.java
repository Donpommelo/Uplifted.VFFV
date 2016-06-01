package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class YellowElevator extends Tile{

	public final static int id = 55;
	public final static BufferedImage texture = Assets.YellowElevator;
	
	public YellowElevator() {
		super(texture, id);
	}
}
