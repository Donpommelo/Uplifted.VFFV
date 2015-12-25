package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StoneFloor extends Tile{

	public final static int id = 7;
	public final static BufferedImage texture = Assets.StoneFloor;
	
	public StoneFloor() {
		super(texture, id);
	}
}
