package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class GlassTile extends Tile{

	public GlassTile(int id, int num) {
		super(TileSorter.TileSort(num,Assets.GlassTile),id);
	}

}
