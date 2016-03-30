package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.VoodooPinStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class VoodooPin extends Item{

	static int id = 34;
	static String name = "Voodoo Pin";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 670;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="TEMP";
	static String descrShort="+15% Purple Resist\nReflects enemy debuffs";
	public status[] enchantment = new status[2];
	public VoodooPin() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new VoodooPinStatus(s,95);
		enchantment[1] = new BonusStatBuff(23, .15 * (1+s.getEquipPow()),s,50);

		return enchantment;
	}
}
