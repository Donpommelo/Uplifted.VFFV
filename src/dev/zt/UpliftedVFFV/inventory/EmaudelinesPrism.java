package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.PrismShield;

public class EmaudelinesPrism extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[1];
	public EmaudelinesPrism() {
		super(2, "Emaudeline's Prism",false,false,false, false,descr, descrShort, 4000, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PrismShield( s.itemDummy,0);
		return enchantment;
	}
}
