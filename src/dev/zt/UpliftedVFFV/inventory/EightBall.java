package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.ElemPointsBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EightBall extends Item{

	static String descr = "A black cue ball that some jerk threw at you.";
	static String descrShort="10% ??? Resistance.";
	public status[] enchantment = new status[1];
	public EightBall() {
		super(2, "8-Ball", false, false, false, false, true, descr);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new ElemPointsBuff(5,10*(1+s.getEquipPow()), s.itemDummy, 50);
		return enchantment;
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
