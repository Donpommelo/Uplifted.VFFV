package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Fishbones extends Item{

	static int id = 2;
	static String name = "Fishbones";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 300;
	static int slot = 1;
	static int lvlReq = 19;
	static String descr="The dried remains of an ancient fish. Its probably a symbol of thanks\nin whatever country Svente emigrated from.";
	static String descrShort = "temp";
	public status[] enchantment = new status[0];
	public Fishbones() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		return enchantment;
	}

}
