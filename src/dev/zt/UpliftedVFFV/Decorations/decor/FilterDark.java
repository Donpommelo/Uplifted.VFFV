package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class FilterDark extends Decor{

	public FilterDark(int idnum) {
		super(Assets.DarkFilter, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}
	public boolean followCamera(){
		return true;
	}

}
