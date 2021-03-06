package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class BackpackBaphomet extends Item{

	static int id = 42;
	static String name = "Backpack Baphomet";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 32;
	static String descr="Powerful friend, but desecrates your other belongings.";
	static String descrShort="+25%Pow\n+25% Red Points\n-75% Equipment Power";
	public status[] enchantment = new status[3];
	public BackpackBaphomet() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(10,-.75, s,5);
		enchantment[1] = new StatBuffMult(2,1.25, s,30);
		enchantment[2] = new ElemPointsBuffMult(0,1.25,s, 40);
		
		return enchantment;
	}
}
