package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SpeedChute extends Item{

	static String descr="A parachute worn on the back to create drag and run slower./ Handy in agility training.";
	static String descrShort="Speed -50%. +15% Exp Gain";
	public status[] enchantment = new status[2];
	public SpeedChute() {
		super(2, "Speed Chute",false,false,false, false, true, descr, descrShort);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TestStatBuff(4,.5, s.itemDummy,10);
		enchantment[1] = new BonusStatBuff(3,0.15*(1+s.getEquipPow()), s.itemDummy,80);
		return enchantment;
	}
}
