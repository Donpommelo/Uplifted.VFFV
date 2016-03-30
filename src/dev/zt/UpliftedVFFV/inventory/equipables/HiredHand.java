package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HiredHandStatus;

public class HiredHand extends Item{

	static int id = 2;
	static String name = "Hired Hand";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr="Greedy familiar that fights on behalf of the highest living bidder.";
	static String descrShort="Ands some punch to your moves.\nTakes a cut of the winnings.";
	
	public status[] enchantment = new status[1];
	public HiredHand() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new HiredHandStatus(s,50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
