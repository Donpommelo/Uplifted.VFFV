package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageBlock;
import dev.zt.UpliftedVFFV.statusEffects.StoneSkin;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LoamSkinTalisman extends Item{

	static int id = 2;
	static String name = "Loamskin Talisman";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="Wholesome talisman of the ever-regenerating earth.";
	static String descrShort="Boosts Hp Regen after taking damage";
	public status[] enchantment = new status[1];
	public LoamSkinTalisman() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StoneSkin(.50 * (1+s.getEquipPow()),s,50);
		return enchantment;
	}
}
