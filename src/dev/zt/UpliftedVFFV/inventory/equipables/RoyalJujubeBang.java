package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RoyalJujubeBangStatus;

public class RoyalJujubeBang extends Item{

	static int id = 95;
	static String name = "Royal Jujube Bang";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Randomly converts Pow to Init or Vice-Versa";
	public status[] enchantment = new status[1];
	public RoyalJujubeBang() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new RoyalJujubeBangStatus(s,50);

		return enchantment;
	}
}
