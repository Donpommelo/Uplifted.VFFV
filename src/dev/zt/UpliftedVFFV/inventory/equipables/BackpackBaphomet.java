package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class BackpackBaphomet extends Item{

	static int id = 2;
	static String name = "Backpack Baphomet";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 32;
	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[3];
	public BackpackBaphomet() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(10,-.75, 50);
		enchantment[1] = new StatBuffMult(2,1.25, 35);
		enchantment[2] = new ElemPointsBuffMult(0,1.25, 35);
		
		return enchantment;
	}
}
