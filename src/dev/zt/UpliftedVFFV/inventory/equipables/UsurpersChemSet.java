package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.StatusonHit;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class UsurpersChemSet extends Item{

	static int id = 46;
	static String name = "Usurper's Chemistry Set";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 260;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A tool for change that no one wants to see used twice.";
	static String descrShort="+8 Skl\nChance to Poison on attack.";
	public status[] enchantment = new status[2];
	public UsurpersChemSet() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusonHit(.5, new Poisoned(3,s,s,50),s,45);
		enchantment[1] = new StatBuffAdd(5, 8, s,50);
		return enchantment;
	}
}
