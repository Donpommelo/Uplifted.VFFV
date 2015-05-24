package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.ElemResBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EightBall extends Item{

	static String descr = "A black cue ball that some jerk threw at you.";
	public status[] enchantment = new status[1];
	public EightBall() {
		super(2, "8-Ball", false, false, false, false, true, descr);
		enchantment[0] = new ElemResBuff(5,.1);
	}
	
	public status[] getEnchantment() {
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s) {
		for(status st : this.enchantment){
			s.statuses.remove(st);
		}
		
	}

}
