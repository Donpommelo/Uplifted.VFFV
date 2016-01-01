package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class FilterUnderwater extends Decor{

	public FilterUnderwater(int idnum) {
		super(Assets.UnderwaterFilter, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}
	public boolean followCamera(){
		return true;
	}

}
