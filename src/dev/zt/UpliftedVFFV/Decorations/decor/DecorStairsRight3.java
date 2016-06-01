package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsRight3 extends Decor{

	public DecorStairsRight3(int idnum) {
		super(Assets.StairsRight3, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
