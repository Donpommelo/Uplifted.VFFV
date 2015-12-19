package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CopyItem;

public class HnHFake extends Item{

	static int id = 2;
	static String name = "Half-n-Half's Fake";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 3700;
	static int slot = 1;
	static int lvlReq = 42;
	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[1];
	public HnHFake() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CopyItem(0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
