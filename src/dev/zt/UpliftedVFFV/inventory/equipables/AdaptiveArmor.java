package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AdaptiveArmorStatus;

public class AdaptiveArmor extends Item{

	static int id = 2;
	static String name = "Adaptive Armor";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 670;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="TEMP";
	static String descrShort="On Wait: Shift from Attack\nto Defense mode.";
	public status[] enchantment = new status[1];
	public AdaptiveArmor() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AdaptiveArmorStatus(50);
		return enchantment;
	}
}
