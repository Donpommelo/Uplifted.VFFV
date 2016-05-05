package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class StatRingFirefly extends Item{

	static int id = 42;
	static String name = "Firefly Ring";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 13;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A ring adjorned by a metal firefly. Fireflies are ";
	static String descrShort="+15% Int";
	public status[] enchantment = new status[1];
	public StatRingFirefly() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffMult(6, 1.15 * (1 + s.getEquipPow()),s, 50);
		return enchantment;
	}
}
