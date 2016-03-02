package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class StatRingAnt extends Item{

	static int id = 2;
	static String name = "Ant Ring";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 13;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A ring adjorned by a metal ant.\nAnts are reknown for their strength and are capable of lifting 100 times their body weight.\nExperts agree that number would be even more if you rounded first.";
	static String descrShort="+15% Pow";
	public status[] enchantment = new status[1];
	public StatRingAnt() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffMult(2, 1.15 * (1 + s.getEquipPow()), 50);
		return enchantment;
	}
}
