package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorSofa3 extends Decor{

	public DecorSofa3(int idnum) {
		super(Assets.Sofa3, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}
	
}
