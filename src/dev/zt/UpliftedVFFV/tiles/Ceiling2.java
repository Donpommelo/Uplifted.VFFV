package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Ceiling2 extends Tile {
	
	public final static int id = 12;
	public final static BufferedImage texture = Assets.Ceiling2;
	
	public Ceiling2() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
