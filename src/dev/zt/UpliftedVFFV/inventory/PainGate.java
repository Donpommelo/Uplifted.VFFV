package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.PainGateStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PainGate extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[1];
	public PainGate() {
		super(2, "Pain Gate",false,false,false, false,descr, descrShort, 85, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PainGateStatus(s.itemDummy);
		return enchantment;
	}
}
