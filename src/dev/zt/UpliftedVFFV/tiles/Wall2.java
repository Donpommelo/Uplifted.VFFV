package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Wall2 extends Tile {

	public Wall2(int id, int num) {
		super(TileSorter.TileSort(num,Assets.Wall1),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
