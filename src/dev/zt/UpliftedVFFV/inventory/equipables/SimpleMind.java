package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SimpleMindStatus;

public class SimpleMind extends Item{

	static int id = 2;
	static String name = "Simple Mind";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 220;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="Thinking. Bad.";
	static String descrShort="User can only have 1 non-permanent status at once.";
	public status[] enchantment = new status[1];
	public SimpleMind() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SimpleMindStatus(s,0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
