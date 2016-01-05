package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsLeft0 extends Decor{

	public DecorStairsLeft0(int idnum) {
		super(Assets.StairsLeft0, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
