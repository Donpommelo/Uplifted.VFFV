package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SportsmanshipAwardStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuffMult;

public class SportsmanshipAward extends Item{

	static int id = 2;
	static String name = "Sportsmanship Award";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 20;
	static String descr="TEMP";
	static String descrShort="+10% Exp gain\n+8 Mp regen\nSportsmanship!";
	public status[] enchantment = new status[3];
	public SportsmanshipAward() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SportsmanshipAwardStatus(50);
		enchantment[1] = new BonusStatBuffMult(3,1.1*(1+s.getEquipPow()),50);
		enchantment[2] = new BonusStatBuff(35,(int)(8*(1+s.getEquipPow())),50);

		return enchantment;
	}
}
