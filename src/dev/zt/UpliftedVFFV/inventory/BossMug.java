package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.AddStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BossMug extends Item{

	static String descr="A coffee mug belonging to the number one boss. You certainly don��t\nknow anyone in this office who fits that description, so don��t bother\nlooking for its rightful owner.";
	static String descrShort="Restore Mp at end of Round.";
	public status[] enchantment = new status[1];
	public BossMug() {
		super(2, "#1 Boss Mug", false, false, false, false, true, descr);
		enchantment[0] = new Regendegen(false,5);
	}
	
	public status[] getEnchantment() {
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s) {
		for(status st : this.enchantment){
			s.statuses.remove(st);
		}
		
	}
	
	public String getDescrShort() {
		return descrShort;
	}


}
