package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.HealBlock;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class SimmerResent extends Item{

	static String descr="Resentment is like swallowing poison and hoping your enemy will\nsuffer; it demonstrates commitment.";
	static String descrShort = "Helps you hold a grudge";
	public status[] enchantment = new status[3];
	public SimmerResent() {
		super(2, "Simmering Resentment",false,false,false, false,descr, descrShort,400,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TestStatBuff(2,(int)(1.2*(1+s.getEquipPow())), s.itemDummy, 25);
		enchantment[1] = new TestStatBuff(4,(int)(1.2*(1+s.getEquipPow())), s.itemDummy, 25);
		enchantment[2] = new HealBlock(s.itemDummy,25);
		return enchantment;
	}

}
