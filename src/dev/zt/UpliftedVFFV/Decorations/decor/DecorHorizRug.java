package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorHorizRug extends Decor{

	public DecorHorizRug(int idnum) {
		super(Assets.HorizRug, idnum);
	}
	public int renderBelow(){
		return -1;
	}
}
