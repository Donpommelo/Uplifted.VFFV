package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.TomeoftheEndStatus;


public class TomeoftheEnd extends Item{

	static int id = 2;
	static String name = "Tome of the End";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 980;
	static int slot = 1;
	static int lvlReq = 35;
	static String descr="An evil-looking tome describing the ends of the world and everything in between.";
	static String descrShort="Standard Attacks sometimes instantly kill.";
	public status[] enchantment = new status[1];
	public TomeoftheEnd() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TomeoftheEndStatus(0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
