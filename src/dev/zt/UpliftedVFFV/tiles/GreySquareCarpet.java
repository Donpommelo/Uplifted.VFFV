package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GreySquareCarpet extends Tile{

	public final static int id = 40;
	public final static BufferedImage texture = Assets.GreySquareCarpet;
	
	public GreySquareCarpet() {
		super(texture, id);
	}
}
