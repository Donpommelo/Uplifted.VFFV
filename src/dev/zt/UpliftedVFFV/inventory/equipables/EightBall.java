package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class EightBall extends Item{

	static int id = 27;
	static String name = "8-Ball";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 111;
	static int slot = 1;
	static int lvlReq = 2;
	static String descr = "A black cue ball that some jerk threw at you.";
	static String descrShort="+15 ??? Alignment.";
	public status[] enchantment = new status[1];
	public EightBall() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new ElemPointsBuff(5,15,s, 50);
		return enchantment;
	}

}
