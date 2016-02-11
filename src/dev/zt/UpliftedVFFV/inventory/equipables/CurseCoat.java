package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CurseCoatStatus;

public class CurseCoat extends Item{

	static int id = 2;
	static String name = "Curse Coat";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 670;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="A ragged coat dripping with the residue of\n millions of long-forgotten curses.";
	static String descrShort="Rerolls debuffs.";
	public status[] enchantment = new status[1];
	public CurseCoat() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CurseCoatStatus(50);
		return enchantment;
	}
}
