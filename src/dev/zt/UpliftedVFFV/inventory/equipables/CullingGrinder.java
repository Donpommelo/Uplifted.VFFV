package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CullingGrinderStatus;

public class CullingGrinder extends Item{

	static int id = 2;
	static String name = "Culling Grinder";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 60;
	static String descr="";
	static String descrShort="";
	
	public status[] enchantment = new status[1];
	public CullingGrinder() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CullingGrinderStatus(50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}