package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorBlackDoor extends Decor{

	public DecorBlackDoor(int idnum) {
		super(Assets.BlackDoor, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
