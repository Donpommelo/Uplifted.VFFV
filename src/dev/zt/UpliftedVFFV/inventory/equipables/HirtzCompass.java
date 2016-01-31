package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HirtzCompassStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class HirtzCompass extends Item{

	static int id = 2;
	static String name = "Hirtz's Compass";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 350;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="An outdated piece of medical equipment.\nHelps you find out where it Hirtz.";
	static String descrShort="+15% Crit Chance\nOn Crit: Lower enemy Crit Resistance.";
	public status[] enchantment = new status[2];
	public HirtzCompass() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(16,.15*(1+s.getEquipPow()), 50);
		enchantment[1] = new HirtzCompassStatus(50);
		return enchantment;
	}
}
