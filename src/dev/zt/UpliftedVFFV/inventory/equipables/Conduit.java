package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class Conduit extends Item{

	static int id = 85;
	static String name = "Conduit";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 235;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="An enchanted trinket that bolsters its wielder's ability to focus.";
	static String descrShort="-30% Mp Costs";
	public status[] enchantment = new status[1];
	public Conduit() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(13,.3*(1+s.getEquipPow()),s, 35);
		return enchantment;
	}
}
