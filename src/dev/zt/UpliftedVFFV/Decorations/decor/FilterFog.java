package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class FilterFog extends Decor{

	public FilterFog(int idnum) {
		super(Assets.FogFilter, idnum);
	}
	
	public int renderBelow(){
		return 1;
	}
	
	public double parallaxMultX(){
		return 0;
	}
	
	public double parallaxMultY(){
		return 0;
	}

}
