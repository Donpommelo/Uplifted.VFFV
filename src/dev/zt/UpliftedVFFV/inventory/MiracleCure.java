package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.MiracleCureStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MiracleCure extends Item{

	static String descr="The powdered remains of some endangered animal.";
	static String descrShort = "Sometimes cures user of negative status.";
	public status[] enchantment = new status[1];
	public MiracleCure() {
		super(2, "Miracle Cure",false, false, false, false,descr, descrShort,320,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MiracleCureStatus(s.getItemDummy(),5);
		return enchantment;
	}

	
}
