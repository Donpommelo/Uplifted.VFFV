package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Blind;
import dev.zt.UpliftedVFFV.statusEffects.StatusImmunity;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CatchersMask extends Item{

	static int id = 2;
	static String name = "Catcher's Mask";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 20;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="Meshed faceguard for protecting the vulnerabilities of the\nowner's face.";
	static String descrShort="Immunity to Blind";
	public status[] enchantment = new status[1];
	public CatchersMask() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusImmunity(new Blind(0), 5);
		return enchantment;
	}
}
