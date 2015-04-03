package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Ceiling2 extends Tile {

	public Ceiling2(int id, int num) {
		super(TileSorter.TileSort(num,Assets.Ceiling2),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
