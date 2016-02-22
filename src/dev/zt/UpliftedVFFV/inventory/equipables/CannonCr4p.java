package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CannonCr4pStatus;

public class CannonCr4p extends Item{

	static int id = 2;
	static String name = "CR4P Cannon";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="TEMP";
	static String descrShort="Fires on Wait.\nDamage foes.";
	public status[] enchantment = new status[1];
	public CannonCr4p() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CannonCr4pStatus(45);
		return enchantment;
	}

}
