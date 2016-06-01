package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorSmudge2 extends Decor{

	public DecorSmudge2(int idnum) {
		super(Assets.Smudge2, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
