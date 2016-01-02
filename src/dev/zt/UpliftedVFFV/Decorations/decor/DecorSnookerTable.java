package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorSnookerTable extends Decor{

	public DecorSnookerTable(int idnum) {
		super(Assets.SnookerTable, idnum);
	}
	public boolean renderBelow(){
		return false;
	}
}
