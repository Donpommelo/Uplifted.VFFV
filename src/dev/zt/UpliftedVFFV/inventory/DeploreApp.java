package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DeploreApp extends Item{

	static String descr="A sinister looking contraption that grants its owner longevity on the\ncondition that he/she doesn��t want it.";
	static String descrShort="Lowers Max Hp, gives Hp regen";
	public status[] enchantment = new status[2];
	public DeploreApp() {
		super(2, "Deplorable Apparatus",false, false, false, false, true,descr);
		enchantment[0] = new Regendegen(true,120);
		enchantment[1] = new TestStatBuff(0,.5);
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
