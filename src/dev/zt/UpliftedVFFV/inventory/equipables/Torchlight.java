package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class Torchlight extends Item{

	static int id = 92;
	static String name = "Torchlight";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A bright light at the end of a long, wooden pole. Used by employees that work in departments designed before proper lighting was introduced to the building.";
	static String descrShort="+20% Accuracy\nLight up dark areas.";
	public status[] enchantment = new status[1];
	public Torchlight() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(1,0.20, s,85);
		return enchantment;
	}
	
	public void onEquip(Schmuck s, int slot, InventoryManager meep, Game game) {
		meep.getGs().setVar(29,meep.getGs().getVar(29)+1);
		super.onEquip(s, slot, meep, game);
	}
	
	public void onUnEquip(Schmuck s, int slot, InventoryManager meep, Game game) {
		meep.getGs().setVar(29,meep.getGs().getVar(29)-1);
		super.onUnEquip(s, slot, meep, game);
	}
	
}
