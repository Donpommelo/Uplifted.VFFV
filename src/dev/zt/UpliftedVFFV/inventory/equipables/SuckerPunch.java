package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AdaptiveArmorStatus;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SuckerPunchStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class SuckerPunch extends Item{

	static int id = 2;
	static String name = "Sucker Punch";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 550;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="TEMP";
	static String descrShort="Punches foes when they miss.";
	public status[] enchantment = new status[2];
	public SuckerPunch() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SuckerPunchStatus(50);
		enchantment[1] = new StatBuffAdd(5,12,50);
		return enchantment;
	}
}
