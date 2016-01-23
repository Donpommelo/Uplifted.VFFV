package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DreamEaterStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class DreamEater extends Item{

	static int id = 2;
	static String name = "Dream Eater";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 550;
	static int slot = 1;
	static int lvlReq = 19;
	static String descr="";
	static String descrShort="+14 Int.\nWielder's damage will not remove Sleep.";
	public status[] enchantment = new status[2];
	public DreamEater() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DreamEaterStatus(60);
		enchantment[1] = new StatBuffAdd(6,(int)(14*(1+s.getEquipPow())), 50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
