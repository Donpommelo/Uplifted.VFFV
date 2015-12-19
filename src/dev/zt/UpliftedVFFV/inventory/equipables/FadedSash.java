package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FadedSash extends Item{

	static int id = 2;
	static String name = "Faded Sash";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 13;
	static String descr="A colorless ribbon that makes you feel less . . . everything.";
	static String descrShort="Take and receive 25% less damage.";
	public status[] enchantment = new status[2];
	public FadedSash() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] =  new BonusStatBuff(7,-.25, 20);
		enchantment[1] =  new BonusStatBuff(8,.25, 20);
		return enchantment;
	}
}
