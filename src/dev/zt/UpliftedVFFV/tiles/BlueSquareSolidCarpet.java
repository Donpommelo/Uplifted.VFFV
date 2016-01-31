package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlueSquareSolidCarpet extends Tile{

	public final static int id = 25;
	public final static BufferedImage texture = Assets.BlueSquareCarpet;
	
	public BlueSquareSolidCarpet() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
