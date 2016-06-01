package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CannonElectrostaticStatus;

public class CannonElectrostatic extends Item{

	static int id = 41;
	static String name = "Cationic Cannon";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="A luminous weapon that comes with its own shades to prevent its user from blinding him or herself.";
	static String descrShort="Fires on Wait.\nDamage and blind foes.";
	public status[] enchantment = new status[1];
	public CannonElectrostatic() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CannonElectrostaticStatus(s,60);
		return enchantment;
	}

}
