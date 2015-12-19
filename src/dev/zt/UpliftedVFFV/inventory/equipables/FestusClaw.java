package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.FestusClawStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FestusClaw extends Item{

	static int id = 2;
	static String name = "Claws of Festus";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1100;
	static int slot = 1;
	static int lvlReq = 37;
	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[3];
	public FestusClaw() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new FestusClawStatus(0);
		enchantment[1] = new BonusStatBuff(16,.35*(1+s.getEquipPow()), 25);
		enchantment[2] = new BonusStatBuff(17,.25*(1+s.getEquipPow()), 25);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
