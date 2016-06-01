package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorTable0 extends Decor{

	public DecorTable0(int idnum) {
		super(Assets.Table0, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
