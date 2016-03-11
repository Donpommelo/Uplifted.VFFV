package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class RingofTesting extends Item{

	static int id = 2;
	static String name = "Ring of Testing";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 322;
	static int slot = 1;
	static int lvlReq = -1;
	static String descr="A ring that grants it bearer the ability to help me test this goddamn game.";
	static String descrShort="Anything, really.";
	public status[] enchantment = new status[4];
	public RingofTesting() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(2,.5, 15);
		enchantment[1] = new BonusStatBuff(16,.25, 50);
		enchantment[2] = new BonusStatBuff(17,2, 50);
		enchantment[3] = new ElemPointsBuff(3,15, 99);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
