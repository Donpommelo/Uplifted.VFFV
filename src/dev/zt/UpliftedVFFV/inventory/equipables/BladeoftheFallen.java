package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Cleave;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class BladeoftheFallen extends Item{

	static int id = 2;
	static String name = "Blade of the Fallen";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 360;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="A blade so heavy that its previous owner kept falling down.";
	static String descrShort="+12 Pow\n-50% Combat Initiative\n-25% Acc\nYour standard attacks damage all foes.";
	public status[] enchantment = new status[4];
	public BladeoftheFallen() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Cleave((int)(.2*(1+s.getEquipPow())), 50);
		enchantment[1] = new BonusStatBuff(0,-.25,50);
		enchantment[2] = new BonusStatBuff(14,-.5,50);
		enchantment[3] = new StatBuffAdd(2,12,50);
		return enchantment;
	}
}
