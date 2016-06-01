package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorRailLeft extends Decor{

	public DecorRailLeft(int idnum) {
		super(Assets.RailLeft, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
