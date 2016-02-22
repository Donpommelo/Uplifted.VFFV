package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Vampirism;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MidgeProboscis extends Item{

	static int id = 2;
	static String name = "Midge Proboscis";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 20;
	static int slot = 1;
	static int lvlReq = 2;
	static String descr="An insect drinking straw for bodily fluids";
	static String descrShort="Standard Attacks restore Hp.";
	public status[] enchantment = new status[1];
	public MidgeProboscis() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Vampirism(.2*(1+s.getEquipPow()), 75);
		return enchantment;
	}
}
