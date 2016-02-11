package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class OverloadSpark extends Item{

	static int id = 2;
	static String name = "Overload Spark";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 540;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr = "A volatile spark of excitability. It makes your\nhair stand on edge.";
	static String descrShort="+8 Yellow Alignment\n+1 use for Limited Use\nitems and skills";
	public status[] enchantment = new status[2];
	public OverloadSpark() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new ElemPointsBuff(3,(int)(8*(1+s.getEquipPow())), 50);
		enchantment[1] = new BonusStatBuff(30,1, 50);

		return enchantment;
	}

}