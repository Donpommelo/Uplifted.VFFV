package dev.zt.UpliftedVFFV.Decorations.decor;

import dev.zt.UpliftedVFFV.gfx.Assets;

public class DecorFlowerTable extends Decor{

	public DecorFlowerTable(int idnum) {
		super(Assets.FlowerTable, idnum);
	}
	
	public boolean renderBelow(){
		return false;
	}

}
