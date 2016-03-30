package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class CatchersGlove extends Item{

	static int id = 22;
	static String name = "Catcher's Mitt";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 18;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A broad glove for catching all sorts of interesting things.";
	static String descrShort="+11% Item Drop.";
	public status[] enchantment = new status[1];
	public CatchersGlove() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(4, .11 *(1+s.getEquipPow()),s, 50);
		return enchantment;
	}
}
