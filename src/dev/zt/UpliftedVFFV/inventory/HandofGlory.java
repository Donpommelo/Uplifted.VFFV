package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.HoGStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class HandofGlory extends Item{

	static String descr="The hand of a murderer preserved in pickle juice and formaldehyde.";
	static String descrShort = "Sometimes stuns enemies.";
	public status[] enchantment = new status[1];
	public HandofGlory() {
		super(2, "Hand of Glory",false, false, false, false, true, descr, descrShort);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new HoGStatus(s.getItemDummy(),5);
		return enchantment;
	}

	
}
