package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class FilterFog extends Decor{

	public FilterFog(int idnum) {
		super(Assets.FogFilter, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}
	public boolean followCamera(){
		return true;
	}

}
