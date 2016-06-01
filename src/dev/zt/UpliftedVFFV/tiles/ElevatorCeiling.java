package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class ElevatorCeiling extends Tile {
	public final static int id = 8;
	public final static BufferedImage texture = Assets.ElevatorCeiling;
	
	public ElevatorCeiling() {
		super(texture, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
