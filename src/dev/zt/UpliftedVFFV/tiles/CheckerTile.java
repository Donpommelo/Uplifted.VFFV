package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class CheckerTile extends Tile{

	public CheckerTile(int id, int num) {
		super(TileSorter.TileSort(num,Assets.CheckerTile),id);
	}
	

}
