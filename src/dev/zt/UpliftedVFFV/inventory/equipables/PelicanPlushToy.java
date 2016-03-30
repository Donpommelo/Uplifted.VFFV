package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class PelicanPlushToy extends Item{

	static int id = 2;
	static String name = "Pelican Plush Toy";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 10;
	static String descr="TEMP";
	static String descrShort="-30% Heal Power";
	public status[] enchantment = new status[1];
	public PelicanPlushToy() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(18,0.3*(1+s.getEquipPow()), s,50);
		return enchantment;
	}
}
