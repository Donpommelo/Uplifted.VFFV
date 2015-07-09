package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.ablities.FireMagnum;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Magnum extends Item{

	static String descr="An gun. You can do gun things with it.";
	static String descrShort="Shoots people.";
	static Skills test = new FireMagnum(0);
	public status[] enchantment = new status[0];
	public Magnum() {
		super(2, "Magnum",false,false,false, false, true, descr, descrShort);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		s.learnSkill(test);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s) {
		s.forgetSkill(test);
		
	}
}
