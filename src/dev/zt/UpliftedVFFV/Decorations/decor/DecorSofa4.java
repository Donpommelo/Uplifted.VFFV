package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorSofa4 extends Decor{

	public DecorSofa4(int idnum) {
		super(Assets.Sofa4, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
