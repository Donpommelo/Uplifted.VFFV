package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Cannabalism;
import dev.zt.UpliftedVFFV.statusEffects.StatusAbsorb;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class GGG extends Item{

	static String descr="A glove that developed an appetite for flesh without need for\nits nutrition.";
	static String descrShort="Heal and take statuses\nwhen incapacitating enemies.\n+11 Skl";
	public status[] enchantment = new status[3];
	public GGG() {
		super(2, "Gluttonous Grey Glove",false,false,false, false,descr, descrShort, 650, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Cannabalism(.40*(1+s.getEquipPow()), s.itemDummy, 80);
		enchantment[1] = new StatusAbsorb(s.itemDummy, 80);
		enchantment[2] = new AddStatBuff(5,11,s.itemDummy, 50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
