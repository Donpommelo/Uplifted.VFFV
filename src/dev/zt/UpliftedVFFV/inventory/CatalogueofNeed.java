package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.CatoNeedStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CatalogueofNeed extends Item{

	static String descr="A rather dry piece of reading\ndetailing the biological needs of\nvarious beings to maintain stable\ninternal conditions.";
	static String descrShort = "Uses meter to prevent lethal damage.";
	public status[] enchantment = new status[1];
	public CatalogueofNeed() {
		super(2, "Catalogue of Need",false, false, false, false, descr, descrShort, 700, 1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CatoNeedStatus(s.getItemDummy(),100);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
