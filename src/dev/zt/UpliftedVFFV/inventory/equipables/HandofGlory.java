package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.HoGStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class HandofGlory extends Item{

	static int id = 2;
	static String name = "Hand of Glory";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 25;
	static String descr="The hand of a murderer preserved in pickle juice and\nformaldehyde.";
	static String descrShort = "+12% Acc\nStuns random enemies.\nRequires Cooldown.";
	public status[] enchantment = new status[2];
	public HandofGlory() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new HoGStatus(5);
		enchantment[1] = new BonusStatBuff(0,.12*(1+s.getEquipPow()), 25);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
