package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class RainbowScale extends Item{

	static int id = 88;
	static String name = "Rainbow Scale";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 16;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="A prismatic scale that shines with different color depending on the angle upon which it is observed.";
	static String descrShort="+4 Prismatic Alignment Points";
	public status[] enchantment = new status[5];
	public RainbowScale() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new ElemPointsBuff(0,4,s,55);
		enchantment[1] = new ElemPointsBuff(1,4,s,55);
		enchantment[2] = new ElemPointsBuff(2,4,s,55);
		enchantment[3] = new ElemPointsBuff(3,4,s,55);
		enchantment[4] = new ElemPointsBuff(4,4,s,55);

		return enchantment;
	}
}
