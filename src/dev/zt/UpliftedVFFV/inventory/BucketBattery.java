package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Volatile;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BucketBattery extends Item{

	static String descr="A bucket filled with old, bulging batteries floating in some sort of\nacidic solution.";
	static String descrShort="May explode when hit.";
	public status[] enchantment = new status[1];
	public BucketBattery() {
		super(2, "Bucket-o-Batteries",false, false, false, false,descr, descrShort,70,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Volatile(s.itemDummy, 25);
		return enchantment;
	}
}
