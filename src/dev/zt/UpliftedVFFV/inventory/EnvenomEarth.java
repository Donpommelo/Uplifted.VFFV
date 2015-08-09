package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.Envenomed;

public class EnvenomEarth extends Item{

	static String descr="Something probably died on this.";
	static String descrShort = "Poisons user and makes tougher. Eventually";
	public int points = 0;
	public status[] enchantment = new status[1];
	public EnvenomEarth() {
		super(2, "Envenomed Earth",false, false, false, false,descr, descrShort, 300,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Envenomed(.15, s.getItemDummy(), this, 1);
		return enchantment;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
}
