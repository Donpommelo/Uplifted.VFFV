package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorRailCenter extends Decor{

	public DecorRailCenter(int idnum) {
		super(Assets.RailMiddle, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
