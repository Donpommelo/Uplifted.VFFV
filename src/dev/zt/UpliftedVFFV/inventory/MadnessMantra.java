package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.MadnessMantraStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MadnessMantra extends Item{

	static String descr="A dusty, arcane scroll. It seems to just have the same word\nwritten on it, repeated over and over.";
	static String descrShort = "Successive uses of abilities boosts pow and Crit but increases mp cost.";
	public status[] enchantment = new status[1];
	public MadnessMantra() {
		super(2, "Madness Mantra",false, false, false, false,descr, descrShort, 500,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MadnessMantraStatus(s.getItemDummy(),75);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
