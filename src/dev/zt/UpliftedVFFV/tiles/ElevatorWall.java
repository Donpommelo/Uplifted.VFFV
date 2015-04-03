package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class ElevatorWall extends Tile {

	public ElevatorWall(int id, int num) {
		super(TileSorter.TileSort(num,Assets.ElevatorWall),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
