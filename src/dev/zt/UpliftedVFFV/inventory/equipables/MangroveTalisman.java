package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.MangroveTalismanStatus;

public class MangroveTalisman extends Item{

	static int id = 82;
	static String name = "Mangrove Talisman";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="Tangled talisman of the all-absorbing mangrove root.";
	static String descrShort="Absorbs first negative status in a fight\nInflicts absorbed status on attacking enemies.";
	public status[] enchantment = new status[1];
	public MangroveTalisman() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MangroveTalismanStatus(s,75);
		return enchantment;
	}
}
