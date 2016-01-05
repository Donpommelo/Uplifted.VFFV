package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorTable7 extends Decor{

	public DecorTable7(int idnum) {
		super(Assets.Table7, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
