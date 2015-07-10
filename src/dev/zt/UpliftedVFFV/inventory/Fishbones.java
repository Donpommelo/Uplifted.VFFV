package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Fishbones extends Item{

	static String descr="The dried remains of an ancient fish. Its probably a symbol of thanks\nin whatever country Svente emigrated from.";
	static String descrShort = "temp";
	public status[] enchantment = new status[0];
	public Fishbones() {
		super(2, "Fish Bones", false, false, false, false,descr, descrShort, 300, 1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		return enchantment;
	}

}
