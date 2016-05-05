package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageReflect;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class CactusSuit extends Item{

	static int id = 42;
	static String name = "Cactus Suit";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 85;
	static int slot = 1;
	static int lvlReq = 14;
	static String descr="A prickly and unfriendly suit. Redundant for those already prickly and unfriendly.";
	static String descrShort="+5 Green Points\n+15 Hp\nReflects damage.";
	public status[] enchantment = new status[3];
	public CactusSuit() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DamageReflect(.25*(1+s.getEquipPow()), s,75);
		enchantment[1] = new StatBuffAdd(0,(int)(15*(1+s.getEquipPow())), s,20);
		enchantment[2] = new ElemPointsBuff(2,(int)(5*(1+s.getEquipPow())),s,65);
		return enchantment;
	}
}
