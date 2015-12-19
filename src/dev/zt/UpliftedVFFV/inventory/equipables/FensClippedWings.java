package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.ablities.ShedFlesh;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FensClippedWings extends Item{

	static int id = 2;
	static String name = "Fen's Clipped Wings";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 960;
	static int slot = 1;
	static int lvlReq = 58;
	static String descr="A gift to Fen from those above.";
	static String descrShort="+20% Eva +15% Init. Lets you shed your skin.";
	static Skills test = new ShedFlesh(0);
	public status[] enchantment = new status[2];
	public FensClippedWings() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		s.learnSkill(test);
		enchantment[0] = new BonusStatBuff(1, .2*(1+s.getEquipPow()), 25);
		enchantment[1] = new BonusStatBuff(14, .15*(1+s.getEquipPow()), 25);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s) {
		s.forgetSkill(test);		
	}
	
	public boolean isLegendary(){
		return true;
	}
}