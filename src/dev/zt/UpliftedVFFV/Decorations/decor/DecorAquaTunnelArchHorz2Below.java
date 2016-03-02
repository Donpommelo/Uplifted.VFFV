package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorAquaTunnelArchHorz2Below extends Decor{

	public DecorAquaTunnelArchHorz2Below(int idnum) {
		super(Assets.HorzTunnelArch2, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
