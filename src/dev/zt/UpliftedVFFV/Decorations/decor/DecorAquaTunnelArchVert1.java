package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchVert1 extends Decor{

	public DecorAquaTunnelArchVert1(int idnum) {
		super(Assets.VertTunnelArch1, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
