package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchHorz3Below extends Decor{

	public DecorAquaTunnelArchHorz3Below(int idnum) {
		super(Assets.HorzTunnelArch3, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
