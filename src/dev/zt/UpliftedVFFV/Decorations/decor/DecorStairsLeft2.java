package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsLeft2 extends Decor{

	public DecorStairsLeft2(int idnum) {
		super(Assets.StairsLeft2, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
