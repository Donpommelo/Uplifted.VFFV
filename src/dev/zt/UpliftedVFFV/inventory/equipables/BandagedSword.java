package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BandagedSwordStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

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
	static String descr="A blade covered by enough bandages that you aren’t really sure if it's even a blade anymore. For all you know, there might just be more bandages underneath.";
	static String descrShort="+7 Skl\nYour Standard Attacks gain initiative.";
	
	public status[] enchantment = new status[2];
	public BandagedSword() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BandagedSwordStatus(s,50);
		enchantment[1] = new StatBuffAdd(5,(int)(7*(1+s.getEquipPow())),s, 20);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
