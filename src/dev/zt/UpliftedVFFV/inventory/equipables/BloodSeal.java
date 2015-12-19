package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BloodSealStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class BloodSeal extends Item{

	static int id = 2;
	static String name = "Blood Seal";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 3;		//Intentionally low for muh lore.
	static int slot = 1;
	static int lvlReq = 48;
	static String descr="This isn��t the most sinister contract you��ve signed before in your employment,\nbut it��s definitely up there.";
	static String descrShort = "+15% Pow, Def and Spd\n+8 Hp and Mp Regen.\nIs there a catch?";
	public status[] enchantment = new status[6];
	public BloodSeal() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BloodSealStatus(10);
		enchantment[1] = new TestStatBuff(2,1.15*(1+s.getEquipPow()), 25);
		enchantment[2] = new TestStatBuff(3,1.15*(1+s.getEquipPow()), 25);
		enchantment[3] = new TestStatBuff(4,1.15*(1+s.getEquipPow()), 25);
		enchantment[4] = new Regendegen(true, (int)(8*(1+s.getEquipPow())), 50);
		enchantment[5] = new Regendegen(false, (int)(8*(1+s.getEquipPow())), 50);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}