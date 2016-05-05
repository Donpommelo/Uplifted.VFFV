package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.VoidCall;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class CalloftheVoid extends Item{

	static int id = 42;
	static String name = "Call of the Void";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 760;
	static int slot = 1;
	static int lvlReq = 38;
	static String descr="TEMP";
	static String descrShort="+10 Int\nLets you heed the void's call.";
	static Skills test = new VoidCall(0);
	public status[] enchantment = new status[1];
	public CalloftheVoid() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		s.learnSkill(test);
		enchantment[0] = new StatBuffAdd(6,(int)(10*(1+s.getEquipPow())), s,75);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s, int slot, InventoryManager meep, Game game) {
		s.forgetSkill(test);		
	}
	
	public boolean isLegendary(){
		return true;
	}
}
