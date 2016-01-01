package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorTallPlant extends Decor{

	public DecorTallPlant(int idnum) {
		super(Assets.notPenPal, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
