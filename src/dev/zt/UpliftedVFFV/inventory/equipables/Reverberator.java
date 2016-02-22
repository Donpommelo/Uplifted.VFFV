package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;
import dev.zt.UpliftedVFFV.statusEffects.StatusImmunity;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Reverberator extends Item{

	static int id = 2;
	static String name = "Reverberator";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 20;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="Wooden core of a Screamer.\nAn endless source of repetitive noise.";
	static String descrShort="Immunity to Silence";
	public status[] enchantment = new status[1];
	public Reverberator() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusImmunity(new Silenced(0), 5);
		return enchantment;
	}
}
