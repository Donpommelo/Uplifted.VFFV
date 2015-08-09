package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RecyclerBolusStatus;

public class RecyclerBolus extends Item{

	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[1];
	public RecyclerBolus() {
		super(2, "Recycler Blous",false,false,false, false,descr, descrShort, 1300, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new RecyclerBolusStatus( s.itemDummy, 50);
		return enchantment;
	}
}
