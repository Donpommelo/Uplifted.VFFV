package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BackpackBuddy extends Item{

	static String descr="";
	static String descrShort="+25% Equipment Power";
	public status[] enchantment = new status[1];
	public BackpackBuddy() {
		super(2, "Backpack Buddy",false,false,false, false,descr, descrShort,200,1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(10,0.25, s.itemDummy,50);
		return enchantment;
	}
}
