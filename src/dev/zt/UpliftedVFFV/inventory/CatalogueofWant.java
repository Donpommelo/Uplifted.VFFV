package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CatoWantStatus;

public class CatalogueofWant extends Item{

	static String descr="A colorful, attention-grabbing magazine\nfilled with reasonably priced offerings\nyou never knew you wanted.";
	static String descrShort = "Cast spells with Hp when low on meter.";
	public status[] enchantment = new status[1];
	public CatalogueofWant() {
		super(2, "Catalogue of Want",false, false, false, false,descr, descrShort, 700, 1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CatoWantStatus(s.getItemDummy(),100);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
