package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlueSquareCarpet extends Tile{

	public final static int id = 25;
	public final static BufferedImage texture = Assets.BlueSquareCarpet;
	
	public BlueSquareCarpet() {
		super(texture, id);
	}
}
