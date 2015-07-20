package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StairsSide2 extends Tile{
	public StairsSide2(int id, int num) {
		super(TileSorter.TileSort(num,Assets.Stairs),id);

		
	}
	
	public int isDiagMove(){
		return -1;
	}
}
