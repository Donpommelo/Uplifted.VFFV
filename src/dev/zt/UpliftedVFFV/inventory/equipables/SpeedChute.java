package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class SpeedChute extends Item{

	static int id = 2;
	static String name = "Speed Chute";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 110;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="A parachute worn on the back to create drag and run slower.\nHandy in agility training.";
	static String descrShort="Speed -50%. +15% Exp Gain";
	public status[] enchantment = new status[2];
	public SpeedChute() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffMult(4,.5, 10);
		enchantment[1] = new BonusStatBuff(3,0.15*(1+s.getEquipPow()), 80);
		return enchantment;
	}
}
