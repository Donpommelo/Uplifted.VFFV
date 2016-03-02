package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CensuredResonanceStatus;

public class CensuredResonance extends Item{

	static int id = 2;
	static String name = "Censured Resonance";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 550;
	static int slot = 1;
	static int lvlReq = 19;
	static String descr="What appears to be some sort of enchanted tuning fork.\nUseful in establishing unspoken connections with quiet coworkers.";
	static String descrShort="Wielder spreads stat buffs to allies.";
	public status[] enchantment = new status[1];
	public CensuredResonance() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CensuredResonanceStatus(100);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
