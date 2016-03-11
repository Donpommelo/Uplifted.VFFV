package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class GomezAmygdala extends Item{

	static int id = 2;
	static String name = "Gomez's Amygdala";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 670;
	static int slot = 1;
	static int lvlReq = 24;
	static String descr="A pulsing organ that once belonged to Gomez who asked you to bring him all the parts of his brain, only to insist that you keep this one.";
	static String descrShort="+11 Int\nStandard Atack scales to Int";
	public status[] enchantment = new status[2];
	public GomezAmygdala() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new StatBuffAdd(6 ,(int)(11*(1+s.getEquipPow())),50);
		enchantment[1] = new BonusStatBuff(26,4,50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
