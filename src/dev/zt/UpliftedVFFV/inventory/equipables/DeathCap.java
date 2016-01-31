package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DeathCapStatus;

public class DeathCap extends Item{

	static int id = 2;
	static String name = "Death Cap";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 630;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr = "A mushroom cap brimming with dangerous-smelling\nspores.";
	static String descrShort="Elementally Reactive Spores";
	public status[] enchantment = new status[1];
	public DeathCap() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DeathCapStatus(50);
		return enchantment;
	}

}
