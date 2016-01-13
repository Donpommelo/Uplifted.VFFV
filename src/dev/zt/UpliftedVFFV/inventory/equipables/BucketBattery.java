package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Volatile;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;

public class BucketBattery extends Item{

	static int id = 2;
	static String name = "Bucket-o-Batteries";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 70;
	static int slot = 1;
	static int lvlReq = 20;
	static String descr="A bucket filled with old, bulging batteries floating in some\nsort of acidic solution.";
	static String descrShort="May explode when hit.";
	public status[] enchantment = new status[2];
	public BucketBattery() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Volatile(25);
		enchantment[1] = new ElemPointsBuffMult(3,1.1*(1+s.getEquipPow()), 50);
		return enchantment;
	}
}
