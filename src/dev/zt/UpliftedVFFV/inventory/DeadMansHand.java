package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Undead;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DeadMansHandStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;

public class DeadMansHand extends Item{

	static String descr="The hand of a dead man.";
	static String descrShort = "Haunts enemies when user is dead.";
	public status[] enchantment = new status[3];
	public DeadMansHand() {
		super(2, "Dead Man's Hand",false, false, false, false, descr, descrShort,850, 1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DeadMansHandStatus(s.getItemDummy(),80);
		enchantment[1] = new Undead(s.getItemDummy(),80);
		enchantment[1] = new ElemPointsBuffMult(4,1.1, s.itemDummy,50);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
