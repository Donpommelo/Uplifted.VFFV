package dev.zt.UpliftedVFFV.tiles;

import java.awt.image.BufferedImage;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class BlueDiagCarpet extends Tile{

	public final static int id = 26;
	public final static BufferedImage texture = Assets.BlueDiagCarpet;
	
	public BlueDiagCarpet() {
		super(texture, id);
	}
}
