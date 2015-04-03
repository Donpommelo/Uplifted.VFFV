package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class ElevatorCeiling extends Tile {

	public ElevatorCeiling(int id, int num) {
		super(TileSorter.TileSort(num,Assets.ElevatorCeiling),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
