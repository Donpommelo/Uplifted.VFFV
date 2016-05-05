package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.FestusClawStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FestusClaw extends Item{

	static int id = 42;
	static String name = "Claws of Festus";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1100;
	static int slot = 1;
	static int lvlReq = 37;
	static String descr="A pair of flexible claw-like wires. Built for the quiet rending of exposed skin or the strangling of noisy coworkers.";
	static String descrShort="+35% Crit Chance\n+35% Crit Multiplier\nNullifies your non-crit actions.";
	public status[] enchantment = new status[3];
	public FestusClaw() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new FestusClawStatus(s,0);
		enchantment[1] = new BonusStatBuff(16,.35*(1+s.getEquipPow()), s,25);
		enchantment[2] = new BonusStatBuff(17,.35*(1+s.getEquipPow()),s, 25);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
