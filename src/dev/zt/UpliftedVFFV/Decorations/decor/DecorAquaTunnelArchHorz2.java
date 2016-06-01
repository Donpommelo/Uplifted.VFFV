package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchHorz2 extends Decor{

	public DecorAquaTunnelArchHorz2(int idnum) {
		super(Assets.HorzTunnelArch2, idnum);
	}
	
	public int renderBelow(){
		return 1;
	}

}
