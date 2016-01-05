package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorTable2 extends Decor{

	public DecorTable2(int idnum) {
		super(Assets.Table2, idnum);
	}

	public int renderBelow(){
		return -1;
	}
	
}
