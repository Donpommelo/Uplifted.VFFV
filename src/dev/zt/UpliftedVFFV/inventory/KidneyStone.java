package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.KidneyStoneStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class KidneyStone extends Item{

	static String descr="A smooth, kidney shaped stone.";
	static String descrShort = "Sometimes cures user of negative status.";
	public status[] enchantment = new status[1];
	public KidneyStone() {
		super(2, "Kidney Stone",false, false, false, false,descr, descrShort,320,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new KidneyStoneStatus(s.getItemDummy(),5);
		return enchantment;
	}

	
}
