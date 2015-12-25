package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorDresser extends Decor{

	public DecorDresser(int idnum) {
		super(Assets.Dresser, idnum);
	}
	
	public boolean renderBelow(){
		return true;
	}
}
