package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsRight1 extends Decor{

	public DecorStairsRight1(int idnum) {
		super(Assets.StairsRight1, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
