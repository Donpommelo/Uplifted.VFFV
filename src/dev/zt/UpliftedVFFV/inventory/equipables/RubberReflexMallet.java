package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.StatusonHit;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class RubberReflexMallet extends Item{

	static int id = 42;
	static String name = "Rubber Reflex Mallet";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 45;
	static String descr="A rubber medical device used in testing neural abnormalities.";
	static String descrShort="Standard Attacks buff target's Crit%";
	public status[] enchantment = new status[1];
	public RubberReflexMallet() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusonHit(1,new BonusStatBuff(0,16,1,s,s,50),s,50);
		return enchantment;
	}

}
