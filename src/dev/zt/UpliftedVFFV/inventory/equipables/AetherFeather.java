package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class AetherFeather extends Item{

	static int id = 2;
	static String name = "Aether Feather";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 16;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A light and airy feather that catches the wind. You would need a lot more of these if you wanted to fly far, far away.";
	static String descrShort="+15% Accuracy\n+5 Yellow Points";
	public status[] enchantment = new status[2];
	public AetherFeather() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(0, .15 * (1 + s.getEquipPow()), 50);
		enchantment[1] = new ElemPointsBuff(3,(int)(5* (1 + s.getEquipPow())),30);
		return enchantment;
	}
}
