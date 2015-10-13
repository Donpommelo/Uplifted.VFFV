package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.AddStatBuff;

public class LetterOpener extends Item{

	static int id = 2;
	static String name = "Letter Opener";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 40;
	static int slot = 1;
	static int lvlReq = 3;
	static String descr="An ornate knife almost threatening enough to be confiscated at an\nairport.";
	static String descrShort="Spd+3  Skl+3";
	public status[] enchantment = new status[2];
	public LetterOpener() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AddStatBuff(4,(int)(3*(1+s.getEquipPow())), s.itemDummy, 50);
		enchantment[1] = new AddStatBuff(5,(int)(3*(1+s.getEquipPow())), s.itemDummy, 50);
		return enchantment;
	}
}
