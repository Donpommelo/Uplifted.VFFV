package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Asleep;
import dev.zt.UpliftedVFFV.statusEffects.StatusCloud;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class TheTentativelyNamedFiles extends Item{

	static int id = 2;
	static String name = "The <> Files";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 20;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="TEMP.";
	static String descrShort="+5 Int\nSometimes inflicts Sleep on\nattacking foes.";
	public status[] enchantment = new status[2];
	public TheTentativelyNamedFiles() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusCloud(50, .1, new Asleep(2,s,50), s, 5);
		enchantment[1] = new StatBuffAdd(6,(int)(5*(1+s.getEquipPow())),50);
		return enchantment;
	}
}
