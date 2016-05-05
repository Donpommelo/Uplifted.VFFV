package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class LuckHoof extends Item{

	static int id = 87;
	static String name = "Lucky Hoof";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 40;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="A black amulet made from the hoove of some unlucky animal.";
	static String descrShort="+11 Luk\n+8 Def";
	public status[] enchantment = new status[2];
	public LuckHoof() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffAdd(3,(int)(8*(1+s.getEquipPow())), s,55);
		enchantment[1] = new StatBuffAdd(7,(int)(11*(1+s.getEquipPow())), s,55);
		return enchantment;
	}
}
