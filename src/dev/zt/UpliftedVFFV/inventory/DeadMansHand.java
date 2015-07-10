package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DeadMansHandStatus;
import dev.zt.UpliftedVFFV.statusEffects.Undead;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DeadMansHand extends Item{

	static String descr="The hand of a dead man.";
	static String descrShort = "Haunts enemies when user is dead.";
	public status[] enchantment = new status[2];
	public DeadMansHand() {
		super(2, "Dead Man's Hand",false, false, false, false, descr, descrShort,850, 1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DeadMansHandStatus(s.getItemDummy(),80);
		enchantment[1] = new Undead(s.getItemDummy(),80);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
