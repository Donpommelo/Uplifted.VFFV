package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.MeterShield;

public class FaradayCage extends Item{

	static int id = 2;
	static String name = "Faraday's Cage";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 840;
	static int slot = 1;
	static int lvlReq = 33;
	static String descr="A conductive mesh that absorbs incoming damage.";
	static String descrShort="Uses meter to reduce damage.";
	public status[] enchantment = new status[1];
	public FaradayCage() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MeterShield(.3*(1+s.getEquipPow()), s.itemDummy, 75);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
