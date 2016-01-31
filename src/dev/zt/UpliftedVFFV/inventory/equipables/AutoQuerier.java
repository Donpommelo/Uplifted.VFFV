package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AutoQuery;

public class AutoQuerier extends Item{

	static int id = 2;
	static String name = "Future-Tech Autoquerier";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 66;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="An automatic scanning device connected to a\nfuturistic database.";
	static String descrShort = "Scans foes at the start of combat.";
	public status[] enchantment = new status[1];
	public AutoQuerier() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AutoQuery(100);
		return enchantment;
	}
}
