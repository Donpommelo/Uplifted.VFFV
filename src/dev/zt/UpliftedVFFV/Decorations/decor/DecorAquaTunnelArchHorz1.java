package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchHorz1 extends Decor{

	public DecorAquaTunnelArchHorz1(int idnum) {
		super(Assets.HorzTunnelArch1, idnum);
	}
	
	public int renderBelow(){
		return 1;
	}

}
