package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.TomeofPermanenceStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class TomeofPermanence extends Item{

	static int id = 42;
	static String name = "Tome of Permanence";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 600;
	static int slot = 1;
	static int lvlReq = 45;
	static String descr="An eternal tome rumored to have no end. Those who have neared its conclusion claim that the book added a few more pages just for them.";
	static String descrShort="+15 Hp\nStandard Attacks sometimes extend duration of debuffs.";
	public status[] enchantment = new status[2];
	public TomeofPermanence() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TomeofPermanenceStatus(s,50);
		enchantment[1] = new StatBuffAdd(0, (int)(15*(1+s.getEquipPow())),s, 50);
		return enchantment;
	}

}
