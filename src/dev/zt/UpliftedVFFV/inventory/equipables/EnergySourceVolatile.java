package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EnergyVolatile;

public class EnergySourceVolatile extends Item{

	static int id = 2;
	static String name = "Volatile Energy Source";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="An immensely powerful energy source whose tendency to explode violently prevents it from being available to consumers.";
	static String descrShort="Painful Mp Regen.";
	public status[] enchantment = new status[1];
	public EnergySourceVolatile() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EnergyVolatile(50);
		return enchantment;
	}
}
