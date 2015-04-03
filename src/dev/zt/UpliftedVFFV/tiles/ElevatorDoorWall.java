package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class ElevatorDoorWall extends Tile {

	public ElevatorDoorWall(int id, int num) {
		super(TileSorter.TileSort(num,Assets.ElevatorDoorWall),id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
