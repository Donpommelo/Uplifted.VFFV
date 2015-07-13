package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.PrehistSynapse;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PrehistoricSynapse extends Item{

	static String descr="A fossilized Neuron from some long extince sea creature.";
	static String descrShort = "Delays damage taken until end of round.";
	public status[] enchantment = new status[1];
	public PrehistoricSynapse() {
		super(2, "Prehistoric Synapse",false, false, false, false,descr, descrShort,800,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PrehistSynapse(s.getItemDummy(),5);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
