package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Deplorable;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DeploreApp extends Item{

	static String descr="A sinister looking contraption that grants its owner longevity on the\ncondition that he/she doesn¡¦t want it.";
	static String descrShort="Lowers Max Hp, gives Hp regen";
	public status[] enchantment = new status[1];
	public DeploreApp() {
		super(2, "Deplorable Apparatus",false, false, false, false, true,descr, descrShort);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Deplorable(s.itemDummy, 5);
		return enchantment;
	}
}
