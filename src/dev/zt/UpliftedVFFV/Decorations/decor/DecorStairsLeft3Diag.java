package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsLeft3Diag extends Decor{

	public DecorStairsLeft3Diag(int idnum) {
		super(Assets.StairsLeft3Diag, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
