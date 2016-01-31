package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class ClockwiseCage extends Item{

	static int id = 2;
	static String name = "Clockwise Cage";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 540;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr = "A peculiar wire birdcage.\nIts occupant occasionally brings you extra time.";
	static String descrShort="+20% Initiative\n-1 turn Cooldown for\napplicable items and skills.";
	public status[] enchantment = new status[2];
	public ClockwiseCage() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(14,(int)(.20*(1+s.getEquipPow())), 50);
		enchantment[1] = new BonusStatBuff(31,1, 50);
		return enchantment;
	}

}
