package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class NewtonCradle extends Item{

	static String descr="An office decoration consisting of multiple swinging metal spheres.\nGreat for employees who can't handle pets.";
	static String descrShort="Skl+6";
	public status[] enchantment = new status[1];
	public NewtonCradle() {
		super(2, "Newton's Cradle",false,false,false, false,descr, descrShort,45,1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AddStatBuff(5,(int)(6*(1+s.getEquipPow())), s.itemDummy, 80);
		return enchantment;
	}
}
