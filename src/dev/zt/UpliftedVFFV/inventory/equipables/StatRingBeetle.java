package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class StatRingBeetle extends Item{

	static int id = 2;
	static String name = "Beetle Ring";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 13;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A ring adjorned by a metal beetle. Beetles of all kinds belong to the order Coleoptera, named after the Greek word for 'sheath', describing their protective front wings and aversion to violence.";
	static String descrShort="+15% Def";
	public status[] enchantment = new status[1];
	public StatRingBeetle() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffMult(3, 1.15 * (1 + s.getEquipPow()), s,50);
		return enchantment;
	}
}
