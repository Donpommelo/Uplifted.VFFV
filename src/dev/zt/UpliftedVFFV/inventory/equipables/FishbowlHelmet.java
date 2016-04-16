package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FishbowlHelmet extends Item{

	static int id = 77;
	static String name = "Fishbowl Helmet";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 300;
	static int slot = 1;
	static int lvlReq = 10;
	static String descr="TEMP";
	static String descrShort="-50% Underwater Penalty/-30% Accuracy";
	public status[] enchantment = new status[2];
	public FishbowlHelmet() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(5,0.50*(1+s.getEquipPow()), s,50);
		enchantment[1] = new BonusStatBuff(0,-.30, s,50);
		return enchantment;
	}
}
