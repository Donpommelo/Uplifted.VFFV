package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class BackpackBuddy extends Item{

	static int id = 2;
	static String name = "Backpack Buddy";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 10;
	static String descr="A helpful stuffed friend that keeps\nyou and your other toys company.";
	static String descrShort="+25% Equipment Power";
	public status[] enchantment = new status[1];
	public BackpackBuddy() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(10,0.25, 50);
		return enchantment;
	}
}
