package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EnergyObsolete;

public class EnergySourceObsolete extends Item{

	static int id = 42;
	static String name = "Obsolete Energy Source";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="An energy source that is powerful and efficient. You can’t imagine why it became obsolete.";
	static String descrShort="Vulnerable Mp Regen.";
	public status[] enchantment = new status[1];
	public EnergySourceObsolete() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EnergyObsolete(s,0);
		return enchantment;
	}
}
