package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AbsoluteThresholdStatus;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SleepytimeSurpriseStatus;

public class SleepytimeSurprise extends Item{

	static int id = 2;
	static String name = "Sleepytime Surprise";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 27;
	static String descr="Hovering, personal drone. Disincentivizes sleeping with\npainful electric shocks.";
	static String descrShort="At the end of rounds\npunish sleeping characters.";
	public status[] enchantment = new status[1];
	public SleepytimeSurprise() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SleepytimeSurpriseStatus(50);
		return enchantment;
	}
	
}
