package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.TomeoftheUnknowableStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class TomeoftheUnknowable extends Item{

	static int id = 42;
	static String name = "Tome of the Unknowable";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 45;
	static String descr="A mysterious book that always seems to be written in every language the reader is illiterate in.";
	static String descrShort="+8 Int\nStandard Attacks inflict random debuffs.";
	public status[] enchantment = new status[2];
	public TomeoftheUnknowable() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TomeoftheUnknowableStatus(s,50);
		enchantment[1] = new StatBuffAdd(4, 8,s, 45);
		return enchantment;
	}

}
