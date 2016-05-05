package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.StatusonHit;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class TomeofEcdysis extends Item{

	static int id = 42;
	static String name = "Tome of Ecdysis";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 600;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="An instructional manual for young insects on the finer points on shedding one's exoskeleton.";
	static String descrShort="Standard Attacks lower Def.";
	public status[] enchantment = new status[1];
	public TomeofEcdysis() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusonHit(1, new StatBuffMult(5,3,.9 *(1-s.getEquipPow()),s,s,50),s,50);
		return enchantment;
	}
}
