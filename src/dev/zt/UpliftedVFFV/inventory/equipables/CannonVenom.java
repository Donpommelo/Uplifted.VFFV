package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CannonVenomStatus;

public class CannonVenom extends Item{

	static int id = 42;
	static String name = "Venom Cannon";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="A poison-spraying cannon used in dousing crop fields with pesticides.";
	static String descrShort="Fires on Wait.\nDamage and poisons foes.";
	public status[] enchantment = new status[1];
	public CannonVenom() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CannonVenomStatus(s,70);
		return enchantment;
	}

}
