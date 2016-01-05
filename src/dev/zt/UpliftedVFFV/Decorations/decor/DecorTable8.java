package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorTable8 extends Decor{

	public DecorTable8(int idnum) {
		super(Assets.Table8, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
