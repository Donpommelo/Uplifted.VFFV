package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EnergyUnethical;

public class EnergySourceUnethical extends Item{

	static int id = 2;
	static String name = "Unethical Energy Source";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 500;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A cost that others pay is hardly a cost at all.";
	static String descrShort="Selfish Mp Regen.";
	public status[] enchantment = new status[1];
	public EnergySourceUnethical() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EnergyUnethical(50);
		return enchantment;
	}
}
