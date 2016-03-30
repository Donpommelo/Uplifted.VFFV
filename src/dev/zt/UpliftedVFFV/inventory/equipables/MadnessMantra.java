package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.MadnessMantraStatus;

public class MadnessMantra extends Item{

	static int id = 2;
	static String name = "Madness Mantra";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 23;
	static String descr="A dusty, arcane scroll. It seems to just have the same word written on it, repeated over and over.";
	static String descrShort = "Successive uses of abilities boosts Pow and Crit but increases mp cost.";
	public status[] enchantment = new status[1];
	public MadnessMantra() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MadnessMantraStatus(s,75);
		return enchantment;
	}
	
}
