package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.PainGateStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class PainGate extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[2];
	public PainGate() {
		super(2, "Pain Gate",false,false,false, false,descr, descrShort, 175, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PainGateStatus(s.itemDummy, 15);
		enchantment[1] = new AddStatBuff(0,25, s.itemDummy,50);
		return enchantment;
	}
}
