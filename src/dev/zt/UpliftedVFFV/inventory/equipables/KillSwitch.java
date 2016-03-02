package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.ablities.KillSelf;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.InventoryManager;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class KillSwitch extends Item{

	static int id = 2;
	static String name = "Kill Switch";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 960;
	static int slot = 1;
	static int lvlReq = 58;
	static String descr="I think Dr. Bloodwood might be trying to tell you something.";
	static String descrShort="+10% Crit Chance\n+12 Attack Damage.\nLets you kill yourself.";
	static Skills test = new KillSelf(0);
	public status[] enchantment = new status[2];
	public KillSwitch() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		s.learnSkill(test);
		enchantment[0] = new BonusStatBuff(16, .1*(1+s.getEquipPow()), 50);
		enchantment[1] = new BonusStatBuff(37, 12*(1+s.getEquipPow()), 25);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s, int slot, InventoryManager meep, Game game) {
		s.forgetSkill(test);		
	}
	
	public boolean isLegendary(){
		return true;
	}
}
