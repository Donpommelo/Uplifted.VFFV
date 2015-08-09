package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HoGStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class HandofGlory extends Item{

	static String descr="The hand of a murderer preserved in pickle juice and formaldehyde.";
	static String descrShort = "Sometimes stuns enemies.";
	public status[] enchantment = new status[2];
	public HandofGlory() {
		super(2, "Hand of Glory",false, false, false, false,descr, descrShort,800,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new HoGStatus(s.getItemDummy(),5);
		enchantment[1] = new BonusStatBuff(0,.12, s.itemDummy,25);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
