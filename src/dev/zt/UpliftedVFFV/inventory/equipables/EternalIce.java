package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EternalIceStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class EternalIce extends Item{

	static int id = 42;
	static String name = "Eternal Ice";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 550;
	static int slot = 1;
	static int lvlReq = 19;
	static String descr="A chunk of ice, frozen at the beginning of time and showing no signs of thawing since.";
	static String descrShort="+17 Hp.\nConverts Blue Alignment to Def";
	public status[] enchantment = new status[2];
	public EternalIce() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EternalIceStatus(s,60);
		enchantment[1] = new StatBuffAdd(0,(int)(17*(1+s.getEquipPow())), s,10);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
