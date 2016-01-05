package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorElevatorPelican extends Decor{

	public DecorElevatorPelican(int idnum) {
		super(Assets.ElevatorFloorMark, idnum);
	}
	
	public int renderBelow(){
		return -1;
	}

}
