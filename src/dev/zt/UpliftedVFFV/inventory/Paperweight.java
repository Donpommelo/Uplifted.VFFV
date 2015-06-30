package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.AddStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Paperweight extends Item{

	static String descr="This is a solid metal paperweight. It weighs down stacks of paperwork\nthat, consequently, weigh down your hopes and dreams.";
	static String descrShort="Def+3";
	public status[] enchantment = new status[1];
	public Paperweight() {
		super(4, "Paperweight",false,false,false,false, true, descr);
		

	}
		
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] =  new AddStatBuff(3,3, s.itemDummy);
		return enchantment;
	}
	
	public String getDescrShort() {
		return descrShort;
	}

}
