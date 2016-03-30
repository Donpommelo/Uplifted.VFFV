package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.LastBreathStatus;

public class LastBreath extends Item{

	static int id = 2;
	static String name = "Last Breath";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1500;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr="A dying breath made audible by relative silence.";
	static String descrShort="+10% Pow for every Silenced character.";
	public status[] enchantment = new status[1];
	public LastBreath() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new LastBreathStatus(s,0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
