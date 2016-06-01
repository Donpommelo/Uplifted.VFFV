package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Delicious;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.StatusonHit;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class DrippingFang extends Item{

	static int id = 36;
	static String name = "Dripping Fang";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 70;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="white, serrated tooth, dripping with infectious hunger.";
	static String descrShort="Inflict Delicious on attack.\nRegain Hp from damaging Delicious foes";
	public status[] enchantment = new status[1];
	public DrippingFang() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatusonHit(1.0, new Delicious(2,.2,s,s,50),s,50);
		return enchantment;
	}
}
