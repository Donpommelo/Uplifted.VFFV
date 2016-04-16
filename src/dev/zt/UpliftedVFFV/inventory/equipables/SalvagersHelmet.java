package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SalvagerHelmetStatus;

public class SalvagersHelmet extends Item{

	static int id = 78;
	static String name = "Salvager's Helmet";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 750;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="+10% Item Drops (20% Underwater)\n-30% Underwater Penalty";
	public status[] enchantment = new status[1];
	public SalvagersHelmet() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SalvagerHelmetStatus(s,50);
		return enchantment;
	}
	
}
