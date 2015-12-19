package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.KidneyStoneStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class KidneyStone extends Item{

	static int id = 2;
	static String name = "Kidney Stone";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 320;
	static int slot = 1;
	static int lvlReq = 26;
	static String descr="A smooth, kidney shaped stone.";
	static String descrShort = "Sometimes cures user of negative status.";
	public status[] enchantment = new status[3];
	public KidneyStone() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new KidneyStoneStatus(5);
		enchantment[1] = new AddStatBuff(0,(int)(18*(1+s.getEquipPow())), 50);
		enchantment[2] = new Regendegen(true, (int)(5*(1+s.getEquipPow())), 50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
