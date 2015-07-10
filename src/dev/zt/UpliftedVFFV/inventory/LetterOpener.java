package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.AddStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LetterOpener extends Item{

	static String descr="An ornate knife almost threatening enough to be confiscated at an\nairport.";
	static String descrShort="Spd+3  Skl+3";
	public status[] enchantment = new status[2];
	public LetterOpener() {
		super(3, "Letter Opener",false,false,false, false, descr, descrShort, 40,1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AddStatBuff(4,(int)(3*(1+s.getEquipPow())), s.itemDummy, 50);
		enchantment[1] = new AddStatBuff(5,(int)(3*(1+s.getEquipPow())), s.itemDummy, 50);
		return enchantment;
	}
}
