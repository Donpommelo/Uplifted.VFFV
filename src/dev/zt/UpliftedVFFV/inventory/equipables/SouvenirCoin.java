package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class SouvenirCoin extends Item{

	static int id = 76;
	static String name = "Souvenir Coin";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 18;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A pressed coin displaying the Aquarium insignia.";
	static String descrShort="+11% Script Drop.";
	public status[] enchantment = new status[1];
	public SouvenirCoin() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(2, .11 ,s, 45);
		return enchantment;
	}
}
