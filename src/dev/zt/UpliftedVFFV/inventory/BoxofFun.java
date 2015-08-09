package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Misaligned;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;

public class BoxofFun extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[2];
	public BoxofFun() {
		super(2, "Skipper's Box of Fun",false,false,false, false,descr, descrShort, 750, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Misaligned( s.itemDummy, 50);
		enchantment[1] = new ElemPointsBuffMult(0,1.1, s.itemDummy,50);
		return enchantment;
	}
}
