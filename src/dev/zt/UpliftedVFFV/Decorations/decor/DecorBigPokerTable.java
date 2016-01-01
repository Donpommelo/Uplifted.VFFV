package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorBigPokerTable extends Decor{

	public DecorBigPokerTable(int idnum) {
		super(Assets.BigPokerTable, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}
}
