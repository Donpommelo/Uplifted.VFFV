package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.GeniusMalignusStatus;

public class GeniusMalignus extends Item{

	static int id =70;
	static String name = "Genius Malignus";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 66;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="";
	static String descrShort = "Makes you invincible. I swear.";
	public status[] enchantment = new status[1];
	public GeniusMalignus() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new GeniusMalignusStatus(s,100);
		return enchantment;
	}
}
