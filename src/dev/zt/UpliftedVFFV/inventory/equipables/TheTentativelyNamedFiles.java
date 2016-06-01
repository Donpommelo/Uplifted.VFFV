package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Asleep;
import dev.zt.UpliftedVFFV.statusEffects.StatusCloud;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class TheTentativelyNamedFiles extends Item{

	static int id = 42;
	static String name = "The <> Files";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 20;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="A folder of boring paperwork. Even a mere glance at its contents can make an employee drowsy.";
	static String descrShort="+5 Int\nSometimes inflicts Sleep on attacking foes.";
	public status[] enchantment = new status[2];
	public TheTentativelyNamedFiles() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusCloud(50,.1, s,new Asleep(2,s,s,50));
		enchantment[1] = new StatBuffAdd(6,5,s,45);
		return enchantment;
	}
}
