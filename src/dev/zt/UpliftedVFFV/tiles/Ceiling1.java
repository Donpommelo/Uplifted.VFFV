package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Ceiling1 extends Tile {
	public final static int id = 10;
	public final static BufferedImage texture = Assets.Ceiling1;
	
	public Ceiling1() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
