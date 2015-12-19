package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.CatoWantStatus;

public class CatalogueofWant extends Item{

	static int id = 2;
	static String name = "Catalogue of Want";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr="A colorful, attention-grabbing magazine\nfilled with reasonably priced offerings\nyou never knew you wanted.";
	static String descrShort = "Cast spells with Hp when low on meter.";
	public status[] enchantment = new status[1];
	public CatalogueofWant() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new CatoWantStatus(100);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
