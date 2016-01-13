package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.HealBlock;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class SimmerResent extends Item{

	static int id = 2;
	static String name = "Simmering Resentment";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 400;
	static int slot = 1;
	static int lvlReq = 17;
	static String descr="Resentment is like swallowing poison and hoping your enemy\nwill suffer; it demonstrates commitment.";
	static String descrShort = "Helps you hold a grudge";
	public status[] enchantment = new status[3];
	public SimmerResent() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new TestStatBuff(2,(int)(1.2*(1+s.getEquipPow())), 25);
		enchantment[1] = new TestStatBuff(4,(int)(1.2*(1+s.getEquipPow())), 25);
		enchantment[2] = new HealBlock(25);
		return enchantment;
	}
}
