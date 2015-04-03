package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Wall1 extends Tile {

	public Wall1(int id, int num) {
		super(TileSorter.TileSort(num,Assets.Wall1),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
