package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

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
	static String descr="An office decoration consisting of multiple swinging metal spheres.\nGreat for employees who can't handle pets.";
	static String descrShort="Skl+6";
	public status[] enchantment = new status[1];
	public NewtonCradle() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AddStatBuff(5,(int)(6*(1+s.getEquipPow())), 80);
		return enchantment;
	}
}
