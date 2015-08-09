package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RingofGygesStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class RingofGyges extends Item{

	static String descr="";
	static String descrShort = "Grants Invisibility at low Health\n+12% Evasion Chance";
	public status[] enchantment = new status[2];
	public RingofGyges() {
		super(2, "Echo Shell",false, false, false, false,descr, descrShort,1150,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new RingofGygesStatus(s.getItemDummy(),40);
		enchantment[1] = new BonusStatBuff(1,.12,s.getItemDummy(),50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
