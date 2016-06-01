package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.FaithlessCloakStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class FaithlessCloak extends Item{

	static int id = 47;
	static String name = "Faithless Cloak";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A shifty and distrustful piece of clothing.\nIts most well-protected areas are located in the back.";
	static String descrShort="+5 Def\nTake -90% damage from allies";
	public status[] enchantment = new status[2];
	public FaithlessCloak() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new FaithlessCloakStatus(s,75);
		enchantment[1] = new StatBuffAdd(3, 5, s,55);
		return enchantment;
	}

}
