package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FadedSash extends Item{

	static String descr="A colorless ribbon that makes you feel less . . . everything.";
	static String descrShort="Pow-50%  Def+50%.";
	public status[] enchantment = new status[2];
	public FadedSash() {
		super(2, "Faded Sash", false,false,false, false, true, descr);
		enchantment[0] =  new TestStatBuff(2,.5);
		enchantment[1] =  new TestStatBuff(3,1.5);
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
