package dev.zt.UpliftedVFFV.tiles;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class VoidTile extends Tile {

	public VoidTile(int id) {
		super(Assets.Void, id);
	}
	
	public boolean isSolid(){
		return true;
	}
}
