package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class Paperweight extends Item{

	static int id = 2;
	static String name = "Paperweight";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 30;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="This is a solid metal paperweight. It weighs down stacks of paperwork\nthat, consequently, weigh down your hopes and dreams.";
	static String descrShort="Def+3";
	public status[] enchantment = new status[1];
	public Paperweight() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
		
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] =  new AddStatBuff(3,(int)(3*(1+s.getEquipPow())), 50);
		return enchantment;
	}
}
