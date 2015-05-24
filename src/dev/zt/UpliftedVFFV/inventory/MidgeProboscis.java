package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Vampirism;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MidgeProboscis extends Item{

	static String descr="An insect drinking straw for bodily fluids";
	public status[] enchantment = new status[1];
	public MidgeProboscis() {
		super(2, "Midge Proboscis",false,false,false, false, true, descr);
		enchantment[0] = new Vampirism(.1);
	}
	
	public status[] getEnchantment() {
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s) {
		for(status st : this.enchantment){
			s.statuses.remove(st);
		}
		
	}

}
