package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CompoundVitreousStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class CompoundVitreous extends Item{

	static int id = 42;
	static String name = "Compound Vitreous";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 790;
	static int slot = 1;
	static int lvlReq = 61;
	static String descr="Enough eyes to see everything you could possibly want to see, and then a little more.";
	static String descrShort="+13% Crit Chance\nLose Resistances instead of missing.";
	public status[] enchantment = new status[2];
	public CompoundVitreous() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CompoundVitreousStatus(s,100);
		enchantment[1] = new BonusStatBuff(16, .13,s, 55);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
