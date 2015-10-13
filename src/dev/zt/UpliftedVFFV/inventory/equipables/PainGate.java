package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.PainGateStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

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
	static String descr="";
	static String descrShort="";
	public status[] enchantment = new status[2];
	public PainGate() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new PainGateStatus(s.itemDummy, 15);
		enchantment[1] = new AddStatBuff(0,(int)(25*(1+s.getEquipPow())), s.itemDummy,50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
