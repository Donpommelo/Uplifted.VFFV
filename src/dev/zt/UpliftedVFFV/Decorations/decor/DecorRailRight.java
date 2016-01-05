package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorRailRight extends Decor{

	public DecorRailRight(int idnum) {
		super(Assets.RailRight, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
