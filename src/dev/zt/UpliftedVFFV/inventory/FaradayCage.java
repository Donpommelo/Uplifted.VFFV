package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.MeterShield;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FaradayCage extends Item{

	static String descr="A conductive mesh that absorbs incoming damage.";
	static String descrShort="Uses meter to reduce damage.";
	public status[] enchantment = new status[1];
	public FaradayCage() {
		super(2, "Faraday's Cage",false,false,false, false,descr, descrShort, 840, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new MeterShield(.3*(1+s.getEquipPow()), s.itemDummy);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
