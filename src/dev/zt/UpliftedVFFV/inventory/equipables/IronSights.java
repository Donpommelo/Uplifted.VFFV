package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.IronSightsStatus;

public class IronSights extends Item{

	static int id = 42;
	static String name = "Iron Sights";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1000;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr="A metal scope designed for sharpshooting from a safe distance.";
	static String descrShort="+50% Accuracy and +30% Crit chance when moving last";
	
	public status[] enchantment = new status[1];
	public IronSights() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new IronSightsStatus(s,50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
