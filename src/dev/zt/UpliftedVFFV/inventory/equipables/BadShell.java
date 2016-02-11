package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageBlock;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BadShell extends Item{

	static int id = 2;
	static String name = "Bad Shell";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 15;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="Even a bad shell affords its contents some protection.";
	static String descrShort="Occasionally blocks some physical damage.";
	public status[] enchantment = new status[1];
	public BadShell() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DamageBlock(.50 ,5 ,6 ,50);
		return enchantment;
	}
}
