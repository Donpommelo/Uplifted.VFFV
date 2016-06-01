package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class StickOnGills extends Item{

	static int id = 91;
	static String name = "Stick-On Gills";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 10;
	static String descr="Adhesive gill stickers for employees that identify as fish.";
	static String descrShort="-25% Underwater Penalty";
	public status[] enchantment = new status[1];
	public StickOnGills() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(5,0.25, s,45);
		return enchantment;
	}
}
