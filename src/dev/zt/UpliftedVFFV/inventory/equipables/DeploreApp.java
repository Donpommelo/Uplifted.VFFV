package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.Deplorable;

public class DeploreApp extends Item{

	static int id = 2;
	static String name = "Deplorable Apparatus";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 900;
	static int slot = 1;
	static int lvlReq = 35;
	static String descr="A sinister looking contraption that grants its owner longevity on the\ncondition that he/she doesn¡¦t want it.";
	static String descrShort="Lowers Max Hp, gives Hp regen";
	public status[] enchantment = new status[1];
	public DeploreApp() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Deplorable(5);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
