package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.KidneyStoneStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class KidneyStone extends Item{

	static String descr="A smooth, kidney shaped stone.";
	static String descrShort = "Sometimes cures user of negative status.";
	public status[] enchantment = new status[3];
	public KidneyStone() {
		super(2, "Kidney Stone",false, false, false, false,descr, descrShort,320,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new KidneyStoneStatus(s.getItemDummy(),5);
		enchantment[1] = new AddStatBuff(0,18, s.itemDummy,50);
		enchantment[2] = new Regendegen(true, 5, s.itemDummy, 50);
		return enchantment;
	}

	
}
