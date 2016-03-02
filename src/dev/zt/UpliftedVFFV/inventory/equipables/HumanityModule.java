package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Misaligned;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HumanityModuleStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class HumanityModule extends Item{

	static int id = 2;
	static String name = "Humanity Module";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 750;
	static int slot = 1;
	static int lvlReq = 20;
	static String descr="Becoming more human has never been easier.";
	static String descrShort="+10 Yellow Points\nConsumes Mp to buff random stats.";
	public status[] enchantment = new status[2];
	public HumanityModule() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new HumanityModuleStatus(50);
		enchantment[1] = new ElemPointsBuff(3,(int)(10*(1+s.getEquipPow())), 50);
		return enchantment;
	}
}
