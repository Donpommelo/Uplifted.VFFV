package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchVert3 extends Decor{

	public DecorAquaTunnelArchVert3(int idnum) {
		super(Assets.VertTunnelArch3, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
