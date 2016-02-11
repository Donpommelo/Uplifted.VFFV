package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.NineLivesStatus;

public class NineLives extends Item{

	static int id = 2;
	static String name = "Ninth Life";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 4000;
	static int slot = 1;
	static int lvlReq = 55;
	static String descr="We all have nine lives.\nSome are just more prone to losing them all at once.";
	static String descrShort="Sets Max Hp to 9\nYou only take 1 damage at a time.";
	public status[] enchantment = new status[1];
	public NineLives() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new NineLivesStatus(0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
