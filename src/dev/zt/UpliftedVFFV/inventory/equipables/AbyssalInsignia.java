package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AbyssalInsigniaStatus;

public class AbyssalInsignia extends Item{

	static int id = 2;
	static String name = "Abyssal Insignia";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 666;
	static int slot = 1;
	static int lvlReq = 33;
	static String descr="Designates its bearer as one of them, whomever they are.";
	static String descrShort = "Grants owner Void Alignment.";
	public status[] enchantment = new status[1];
	public AbyssalInsignia() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AbyssalInsigniaStatus(s.getItemDummy(),100);
		return enchantment;
	}
	
}
