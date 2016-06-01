package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.TommorowmanTalismanStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class TommorowmanTalisman extends Item{

	static int id = 42;
	static String name = "Tommorowman's Talisman";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 555;
	static int slot = 1;
	static int lvlReq = 36;
	static String descr="An artifact for the future-minded. Believed by the Tommorowmen to be redeemable for salvation on the eve of Apocalypse.";
	static String descrShort = "+11 Int\n+15% Combat Initiative\nDelays new statuses until next turn.";
	public status[] enchantment = new status[3];
	public TommorowmanTalisman() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TommorowmanTalismanStatus(s,50);
		enchantment[1] = new StatBuffAdd(6,11,s, 25);
		enchantment[2] = new BonusStatBuff(14,0.15, s,45);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
