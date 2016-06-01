package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class SandGroundTile extends Tile{

	public final static int id = 28;
	public final static BufferedImage texture = Assets.SandTile;
	
	public SandGroundTile() {
		super(texture, id);
	}
}
