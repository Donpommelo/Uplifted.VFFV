package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SalvagerScrapRipperStatus;

public class SalvagersScrapRipper extends Item{

	static int id = 79;
	static String name = "Salvager's Scrap Ripper";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 750;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="+15% Crit Chance/On Crit: Increases Item Drops";
	public status[] enchantment = new status[1];
	public SalvagersScrapRipper() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SalvagerScrapRipperStatus(s,50);
		return enchantment;
	}
	
}
