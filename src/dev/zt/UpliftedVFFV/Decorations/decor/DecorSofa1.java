package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorSofa1 extends Decor{

	public DecorSofa1(int idnum) {
		super(Assets.Sofa1, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}
}
