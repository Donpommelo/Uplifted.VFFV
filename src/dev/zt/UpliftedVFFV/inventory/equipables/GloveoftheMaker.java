package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class GloveoftheMaker extends Item{

	static int id = 42;
	static String name = "Glove of the Maker";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 555;
	static int slot = 1;
	static int lvlReq = 36;
	static String descr="Dr. Bloodwood didn't just hate getting his hands dirty. He hated getting his gloves dirty too.";
	static String descrShort = "+30% Effectiveness with Combat Items.\n+10% Equipment Power.";
	public status[] enchantment = new status[2];
	public GloveoftheMaker() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(9,.3, s,5);
		enchantment[1] = new BonusStatBuff(10,.1, s,5);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
