package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.AddStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class NewtonCradle extends Item{

	static String descr="An office decoration consisting of multiple swinging metal spheres.\nGreat for employees who can't handle pets.";
	static String descrShort="Skl+6";
	public status[] enchantment = new status[1];
	public NewtonCradle() {
		super(2, "Newton's Cradle",false,false,false, false, true, descr);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AddStatBuff(4,6, s.itemDummy);
		return enchantment;
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
