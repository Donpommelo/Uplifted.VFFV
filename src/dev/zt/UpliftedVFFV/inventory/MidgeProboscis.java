package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Vampirism;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MidgeProboscis extends Item{

	static String descr="An insect drinking straw for bodily fluids";
	static String descrShort="Lifesteal on attacks.";
	public status[] enchantment = new status[1];
	public MidgeProboscis() {
		super(2, "Midge Proboscis",false,false,false, false, true, descr);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Vampirism(.1, s.itemDummy);
		return enchantment;
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
