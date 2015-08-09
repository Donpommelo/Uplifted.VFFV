package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BandagedSwordStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class BandagedSword extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[2];
	public BandagedSword() {
		super(2, "Bandanged Sword",false,false,false, false,descr, descrShort, 1300, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BandagedSwordStatus( s.itemDummy, 50);
		enchantment[1] = new AddStatBuff(3,(int)(7*(1+s.getEquipPow())), s.itemDummy, 20);
		return enchantment;
	}
}
