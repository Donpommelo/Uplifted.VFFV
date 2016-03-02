package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchCornerBelow extends Decor{

	public DecorAquaTunnelArchCornerBelow(int idnum) {
		super(Assets.TunnelArchCorner, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
