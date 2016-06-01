package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchHorz1Below extends Decor{

	public DecorAquaTunnelArchHorz1Below(int idnum) {
		super(Assets.HorzTunnelArch1, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
