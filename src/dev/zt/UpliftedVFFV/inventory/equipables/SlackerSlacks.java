package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SlackerSlacksStatus;

public class SlackerSlacks extends Item{

	static int id = 5;
	static String name = "Slacker Slacks";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 16;
	static int slot = 1;
	static int lvlReq = 2;
	static String descr="A comfortable pair of pants that accomodate all manner of dilly-dallying, dawdling and dicking-arounderery.";
	static String descrShort="Regenerates Hp when Waiting.";
	public status[] enchantment = new status[1];
	public SlackerSlacks() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SlackerSlacksStatus(s,50);
		return enchantment;
	}
}
