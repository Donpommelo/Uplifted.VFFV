package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RecyclerBolusStatus;

public class RecyclerBolus extends Item{

	
	static int id = 2;
	static String name = "Recycler Bolus";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1300;
	static int slot = 1;
	static int lvlReq = 36;
	static String descr="A hardened clump of undigested food from the throat of an ancient recycler.\nGiven the diet of recyclers, “food” is hardly a descriptive word.";
	static String descrShort="Damage enemies when healing.";
	public status[] enchantment = new status[1];
	public RecyclerBolus() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new RecyclerBolusStatus(50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
