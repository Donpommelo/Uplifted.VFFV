package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsRight0 extends Decor{

	public DecorStairsRight0(int idnum) {
		super(Assets.StairsRight0, idnum);
	}

	public int renderBelow(){
		return -1;
	}
}
