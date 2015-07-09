package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Cannabalism;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class GGG extends Item{

	static String descr="A glove that developed an appetite for flesh without need for\nits nutrition.";
	static String descrShort="Heal when incapacitating enemies.";
	public status[] enchantment = new status[1];
	public GGG() {
		super(2, "Gluttonous Grey Glove",false,false,false, false, true, descr, descrShort);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Cannabalism(.40*(1+s.getEquipPow()), s.itemDummy);
		return enchantment;
	}
}
