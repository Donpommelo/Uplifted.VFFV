package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.PrehistSynapse;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class PrehistoricSynapse extends Item{

	static int id = 42;
	static String name = "Prehistoric Synapse";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 32;
	static String descr="A fossilized neural fiber from some long extinct sea creature. You don't imagine they had particularly quick reflexes.";
	static String descrShort = "+11% Eva\n+11%Crit\nDelays damage taken until end of round.";
	public status[] enchantment = new status[3];
	public PrehistoricSynapse() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PrehistSynapse(s,5);
		enchantment[1] = new BonusStatBuff(1,0.11, s,75);
		enchantment[2] = new BonusStatBuff(16,0.11, s,75);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
