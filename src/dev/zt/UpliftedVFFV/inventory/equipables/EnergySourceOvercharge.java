package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EnergyOvercharged;

public class EnergySourceOvercharge extends Item{

	static int id = 2;
	static String name = "Overloaded Energy Source";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A powerful but overused source of energy that is difficult to transport and store.";
	static String descrShort="Monopolized Mp Regen";
	public status[] enchantment = new status[1];
	public EnergySourceOvercharge() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EnergyOvercharged(s,50);
		return enchantment;
	}
}
