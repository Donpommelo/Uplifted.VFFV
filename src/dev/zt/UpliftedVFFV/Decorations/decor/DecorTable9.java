package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorTable9 extends Decor{

	public DecorTable9(int idnum) {
		super(Assets.Table9, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
