package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RedTideTalismanStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class RedTideTalisman extends Item{

	static int id = 95;
	static String name = "Red Tide Talisman";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="User's Poisons deal Red Damage.\n+6 Red Alignment Points.";
	public status[] enchantment = new status[2];
	public RedTideTalisman() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new RedTideTalismanStatus(s,50);
		enchantment[1] = new ElemPointsBuff(0, 6, s,31);

		return enchantment;
	}
}
