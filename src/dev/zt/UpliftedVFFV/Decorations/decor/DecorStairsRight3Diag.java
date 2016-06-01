package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsRight3Diag extends Decor{

	public DecorStairsRight3Diag(int idnum) {
		super(Assets.StairsRight3Diag, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
