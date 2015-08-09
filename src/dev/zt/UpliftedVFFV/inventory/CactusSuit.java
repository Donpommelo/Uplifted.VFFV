package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageReflect;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class CactusSuit extends Item{

	static String descr="A prickly and unfriendly suit";
	static String descrShort="Reflects damage against foes.";
	public status[] enchantment = new status[3];
	public CactusSuit() {
		super(2, "Cactus Suit",false,false,false, false,descr, descrShort, 85, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DamageReflect(.3*(1+s.getEquipPow()), s.itemDummy, 75);
		enchantment[1] = new AddStatBuff(0,(int)(15*(1+s.getEquipPow())), s.itemDummy, 20);
		enchantment[2] = new ElemPointsBuff(2,5, s.itemDummy,65);
		return enchantment;
	}
}
