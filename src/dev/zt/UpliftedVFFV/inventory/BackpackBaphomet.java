package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class BackpackBaphomet extends Item{

	static String descr="";
	static String descrShort="+25% Equipment Power";
	public status[] enchantment = new status[3];
	public BackpackBaphomet() {
		super(2, "Backpack Buddy",false,false,false, false,descr, descrShort,200,1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(10,-.75, s.itemDummy,50);
		enchantment[1] = new TestStatBuff(2,1.25, s.itemDummy,35);
		enchantment[2] = new ElemPointsBuffMult(0,1.25, s.itemDummy,35);
		
		return enchantment;
	}
}
