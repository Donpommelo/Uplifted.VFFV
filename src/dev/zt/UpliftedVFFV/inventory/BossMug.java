package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BossMug extends Item{

	static String descr="A coffee mug belonging to the number one boss. You certainly don¡¦t\nknow anyone in this office who fits that description, so don¡¦t bother\nlooking for its rightful owner.";
	static String descrShort="Restore Mp at end of Round.";
	public status[] enchantment = new status[1];
	public BossMug() {
		super(2, "#1 Boss Mug", false, false, false, false, true, descr);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Regendegen(false,(int)(5*(1+s.getEquipPow())), s.itemDummy);
		return enchantment;
	}
	
	public String getDescrShort() {
		return descrShort;
	}


}
