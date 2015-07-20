package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class StairsSide1 extends Tile{
	public StairsSide1(int id, int num) {
		super(TileSorter.TileSort(num,Assets.Stairs),id);

		
	}
	
	public int isDiagMove(){
		return 1;
	}

}
