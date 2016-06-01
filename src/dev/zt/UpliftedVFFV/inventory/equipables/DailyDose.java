package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DailyDoseStatus;

public class DailyDose extends Item{

	static int id = 42;
	static String name = "Daily Dose";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 670;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="Automated, self-medicating device for the forgetful.";
	static String descrShort="Automatically uses status-curing items without spending a turn.";
	public status[] enchantment = new status[1];
	public DailyDose() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DailyDoseStatus(s,90);
		return enchantment;
	}
}
