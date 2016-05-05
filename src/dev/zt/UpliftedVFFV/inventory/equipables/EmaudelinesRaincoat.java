package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageCap;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EmaudelinesRaincoat extends Item{

	static int id = 42;
	static String name = "Emaudeline's Raincoat";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 4400;
	static int slot = 1;
	static int lvlReq = 57;
	static String descr="A sturdy coat for keeping out the rain. It’s still a little warm.";
	static String descrShort="User cannot take more than 200 Blue damage in one instance of damage.";
	public status[] enchantment = new status[1];
	public EmaudelinesRaincoat() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DamageCap(1,(int)(200*(1-s.getEquipPow())),s, 0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
