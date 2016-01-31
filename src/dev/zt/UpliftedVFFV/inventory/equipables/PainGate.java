package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.PainGateStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class PainGate extends Item{

	static int id = 2;
	static String name = "Pain Gate";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 175;
	static int slot = 1;
	static int lvlReq = 16;
	static String descr="TEMP";
	static String descrShort="+25 Max Hp\nRounds damage taken to nearest 20.";
	public status[] enchantment = new status[2];
	public PainGate() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PainGateStatus(15);
		enchantment[1] = new StatBuffAdd(0,(int)(25*(1+s.getEquipPow())), 50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
