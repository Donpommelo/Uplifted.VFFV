package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CannonSuperSoakerStatus;

public class CannonSuperSoaker extends Item{

	static int id = 2;
	static String name = "Super Soaker";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="TEMP";
	static String descrShort="Fires on Wait.\nDeals Blue damage to foes.";
	public status[] enchantment = new status[1];
	public CannonSuperSoaker() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CannonSuperSoakerStatus(55);
		return enchantment;
	}

}
