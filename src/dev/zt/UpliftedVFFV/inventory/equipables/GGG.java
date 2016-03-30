package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Cannabalism;
import dev.zt.UpliftedVFFV.statusEffects.StatusAbsorb;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class GGG extends Item{

	static int id = 2;
	static String name = "Gluttonous Grey Glove";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 650;
	static int slot = 1;
	static int lvlReq = 31;
	static String descr="A glove that developed an appetite for flesh without need for its nutrition.";
	static String descrShort="+11 Skl\nHeal and take statuses when incapacitating enemies.";
	public status[] enchantment = new status[3];
	public GGG() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Cannabalism(.40*(1+s.getEquipPow()), s,80);
		enchantment[1] = new StatusAbsorb(s,80);
		enchantment[2] = new StatBuffAdd(5,(int)(11*(1+s.getEquipPow())),s,50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
