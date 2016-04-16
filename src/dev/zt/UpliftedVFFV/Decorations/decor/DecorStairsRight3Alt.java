package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsRight3Alt extends Decor{

	public DecorStairsRight3Alt(int idnum) {
		super(Assets.StairsRight3Alt, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
