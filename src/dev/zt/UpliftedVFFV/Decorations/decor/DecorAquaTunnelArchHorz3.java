package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchHorz3 extends Decor{

	public DecorAquaTunnelArchHorz3(int idnum) {
		super(Assets.HorzTunnelArch3, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
