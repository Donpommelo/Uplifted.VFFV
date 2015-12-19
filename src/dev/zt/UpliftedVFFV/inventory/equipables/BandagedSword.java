package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BandagedSwordStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class BandagedSword extends Item{

	static int id = 2;
	static String name = "Bandanged Sword";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1300;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr="";
	static String descrShort="";
	
	public status[] enchantment = new status[2];
	public BandagedSword() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BandagedSwordStatus(50);
		enchantment[1] = new AddStatBuff(3,(int)(7*(1+s.getEquipPow())), 20);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}