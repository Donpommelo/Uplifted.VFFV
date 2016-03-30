package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.SalvagerToolBeltStatus;

public class SalvagersToolbelt extends Item{

	static int id = 2;
	static String name = "Salvager's Toolbelt";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 750;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="The right tool for the job!/Scales with +Item Drop";
	public status[] enchantment = new status[1];
	public SalvagersToolbelt() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new SalvagerToolBeltStatus(s,50);
		return enchantment;
	}
	
}
