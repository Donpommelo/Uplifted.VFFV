package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.KinhunterStatus;

public class Kinhunter extends Item{

	static int id = 2;
	static String name = "Kinhunter";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 875;
	static int slot = 1;
	static int lvlReq = 29;
	static String descr="In no company is this sort of thing encouraged.";
	static String descrShort="+30% damage dealt to targetsnof the same elemental alignment.";
	public status[] enchantment = new status[1];
	public Kinhunter() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new KinhunterStatus(0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
