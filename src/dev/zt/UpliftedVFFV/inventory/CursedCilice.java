package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Masochist;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CursedCilice extends Item{

	static String descr="A band lined with thorns on the inside.";
	static String descrShort="Regains meter when taking damage.";
	public status[] enchantment = new status[1];
	public CursedCilice() {
		super(2, "Cursed Cilice",false,false,false, false, descr, descrShort, 200, 1);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Masochist(.40*(1+s.getEquipPow()), s.itemDummy, 25);
		return enchantment;
	}
}
