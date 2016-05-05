package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AbsoluteThresholdStatus;

public class AbsoluteThreshold extends Item{

	static int id = 42;
	static String name = "Absolute Threshold";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="The ability to ignore the little things in life.";
	static String descrShort="Negates small instances of damage.";
	public status[] enchantment = new status[1];
	public AbsoluteThreshold() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AbsoluteThresholdStatus(.05*(1+s.getEquipPow()),s, 90);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
