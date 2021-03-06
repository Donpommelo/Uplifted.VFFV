package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class BossMug extends Item{

	static int id = 25;
	static String name = "#1 Boss Mug";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 35;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A coffee mug belonging to the number one boss. You certainly don't know anyone in this office who fits that description, so don't bother looking for its rightful owner.";
	static String descrShort="+5 Mp Regen";
	public status[] enchantment = new status[1];
	public BossMug() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(35,5,s, 35);
		return enchantment;
	}
}
