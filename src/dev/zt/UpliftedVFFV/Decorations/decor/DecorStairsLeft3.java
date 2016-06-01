package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsLeft3 extends Decor{

	public DecorStairsLeft3(int idnum) {
		super(Assets.StairsLeft3, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
