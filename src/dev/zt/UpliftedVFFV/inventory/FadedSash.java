package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FadedSash extends Item{

	static String descr="A colorless ribbon that makes you feel less . . . everything.";
	static String descrShort="Pow-50%  Def+50%.";
	public status[] enchantment = new status[2];
	public FadedSash() {
		super(2, "Faded Sash", false,false,false, false,descr, descrShort, 200, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] =  new BonusStatBuff(7,-.5, s.itemDummy,20);
		enchantment[1] =  new BonusStatBuff(8,.5, s.itemDummy,20);
		return enchantment;
	}
}
