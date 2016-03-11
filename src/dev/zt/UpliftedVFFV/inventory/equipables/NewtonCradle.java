package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.NewtonsCradleStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class NewtonCradle extends Item{

	static int id = 2;
	static String name = "Newton's Cradle";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 450;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="An office decoration consisting of multiple swinging metal spheres. Great for employees who can't handle pets.";
	static String descrShort="+15% Combat Initiative\nTransfers Momentum";
	public status[] enchantment = new status[2];
	public NewtonCradle() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new NewtonsCradleStatus(50);
		enchantment[1] = new BonusStatBuff(14,.15*(1+s.getEquipPow()),50);
		return enchantment;
	}
}
