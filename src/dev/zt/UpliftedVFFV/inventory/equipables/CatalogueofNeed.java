package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CatoNeedStatus;

public class CatalogueofNeed extends Item{

	static int id = 2;
	static String name = "Catalogue of Need";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr="A rather dry piece of reading detailing the biological\nneeds of various beings to maintain stable internal\nconditions.";
	static String descrShort = "Uses meter to prevent lethal damage.";
	public status[] enchantment = new status[1];
	public CatalogueofNeed() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CatoNeedStatus(100);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
