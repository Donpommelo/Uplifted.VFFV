package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorStairsLeft3Alt extends Decor{

	public DecorStairsLeft3Alt(int idnum) {
		super(Assets.StairsLeft3Alt, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
