package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageReflect;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CactusSuit extends Item{

	static String descr="A prickly and unfriendly suit";
	static String descrShort="Reflects damage against foes.";
	public status[] enchantment = new status[1];
	public CactusSuit() {
		super(2, "Cactus Suit",false,false,false, false,descr, descrShort, 85, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DamageReflect(.3*(1+s.getEquipPow()), s.itemDummy);
		return enchantment;
	}
}
