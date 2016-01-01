package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchVert2 extends Decor{

	public DecorAquaTunnelArchVert2(int idnum) {
		super(Assets.VertTunnelArch2, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
