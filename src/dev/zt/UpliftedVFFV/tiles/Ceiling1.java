package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class Ceiling1 extends Tile {

	public Ceiling1(int id, int num) {
		super(TileSorter.TileSort(num,Assets.Ceiling1),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
