package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class StatRingCricket extends Item{

	static int id = 2;
	static String name = "Cricket Ring";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 13;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A ring adjorned by a metal cricket.\nCrickets are seen as symbols of good luck in certain cultures due to their musical aptitude.\nSome crickets were domesticated by the elite and, because of their fraility, must have been very lucky indeed.";
	static String descrShort="+15% Luk";
	public status[] enchantment = new status[1];
	public StatRingCricket() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffMult(7, 1.15 * (1 + s.getEquipPow()), 50);
		return enchantment;
	}
}
