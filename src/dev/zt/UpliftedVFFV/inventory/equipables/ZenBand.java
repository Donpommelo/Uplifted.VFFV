package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class ZenBand extends Item{

	static int id = 42;
	static String name = "Zen Headband";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 270;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr = "A hairband for zen practitioners that still have hair.";
	static String descrShort="+5 Hp Regen\n+5 Def\nYour channeling requires 30% more damage to break.";
	public status[] enchantment = new status[3];
	public ZenBand() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(31,0.3, s,55);
		enchantment[1] = new BonusStatBuff(34,5, s,55);
		enchantment[2] = new StatBuffAdd(3,5, s,55);
		return enchantment;
	}

}
