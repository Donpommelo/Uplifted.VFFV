package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.LeperKhansBladeStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class LeperKhansBlade extends Item{

	static int id = 42;
	static String name = "Leper Khan's Blade";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 700;
	static int slot = 1;
	static int lvlReq = 45;
	static String descr="A disease-ridden sword previously owned by the formidible Leper Khan. What do you call a gathering of lepers?\nA Leper-Con.";
	static String descrShort="+15 Attack Damage\nStandard Attacks spread debuffs.";
	public status[] enchantment = new status[2];
	public LeperKhansBlade() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new LeperKhansBladeStatus(s,50);
		enchantment[1] = new BonusStatBuff(37, (int)(15*(1+s.getEquipPow())), s,50);
		return enchantment;
	}

}
