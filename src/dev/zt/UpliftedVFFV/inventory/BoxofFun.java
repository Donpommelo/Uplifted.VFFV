package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Misaligned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BoxofFun extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[1];
	public BoxofFun() {
		super(2, "Skipper's Box of Fun",false,false,false, false,descr, descrShort, 750, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Misaligned( s.itemDummy);
		return enchantment;
	}
}
