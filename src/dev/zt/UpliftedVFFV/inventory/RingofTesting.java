package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.ElemPointsBuff;
import dev.zt.UpliftedVFFV.statusEffects.Impatient;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RingofTesting extends Item{

	static String descr="A ring that grants it bearer the ability to help me test this\ngoddamn game.";
	static String descrShort="Anything, really.";
	public status[] enchantment = new status[4];
	public RingofTesting() {
		super(2, "Ring of Testing",false,false,false, false, true, descr);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(2,.5, s.itemDummy,15);
		enchantment[1] = new BonusStatBuff(16,.25, s.itemDummy,50);
		enchantment[2] = new BonusStatBuff(17,2, s.itemDummy,50);
		enchantment[3] = new ElemPointsBuff(3,15,s.itemDummy,99);
		return enchantment;
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
