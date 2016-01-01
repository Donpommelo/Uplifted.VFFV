package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchCorner extends Decor{

	public DecorAquaTunnelArchCorner(int idnum) {
		super(Assets.TunnelArchCorner, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
