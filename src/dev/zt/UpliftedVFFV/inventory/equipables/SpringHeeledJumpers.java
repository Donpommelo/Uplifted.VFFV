package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SpringHeeledJumpersStatus;

public class SpringHeeledJumpers extends Item{

	static int id = 2;
	static String name = "Spring-Heels";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 670;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="A pair of fashionable boots with spring-loaded heels. Handy for getting the jump.";
	static String descrShort="On Wait: Temporarily shift Def to Pow.";
	public status[] enchantment = new status[1];
	public SpringHeeledJumpers() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SpringHeeledJumpersStatus(s,50);
		return enchantment;
	}
}
