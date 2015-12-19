package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Misaligned;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class BoxofFun extends Item{

	static int id = 2;
	static String name = "Skipper's Box of Fun";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 750;
	static int slot = 1;
	static int lvlReq = 20;
	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[2];
	public BoxofFun() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Misaligned(50);
		enchantment[1] = new ElemPointsBuff(0,(int)(10*(1+s.getEquipPow())), 50);
		return enchantment;
	}
}
