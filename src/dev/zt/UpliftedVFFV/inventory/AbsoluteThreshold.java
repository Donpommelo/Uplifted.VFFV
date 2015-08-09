package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AbsoluteThresholdStatus;

public class AbsoluteThreshold extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[1];
	public AbsoluteThreshold() {
		super(2, "Absolute Threshold",false,false,false, false,descr, descrShort, 800, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AbsoluteThresholdStatus(.05*(1+s.getEquipPow()), s.itemDummy, 80);
		return enchantment;
	}
}
