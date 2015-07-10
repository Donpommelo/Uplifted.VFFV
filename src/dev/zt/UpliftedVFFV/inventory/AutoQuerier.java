package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.AutoQuery;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AutoQuerier extends Item{

	static String descr="An automatic scanning device hooked up to a\nfuturistic database.";
	static String descrShort = "Scans foes at the start of combat.";
	public status[] enchantment = new status[1];
	public AutoQuerier() {
		super(2, "Future-Tech Autoquerier",false, false, false, false, true, descr, descrShort);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AutoQuery(s.getItemDummy(),100);
		return enchantment;
	}
	
}