package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.ablities.FireMagnum;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Magnum extends Item{

	static int id = 2;
	static String name = "Magnum";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 200;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="It doesn't kill people, but you can.";
	static String descrShort="Shoots people.";
	static Skills test = new FireMagnum(0);
	public status[] enchantment = new status[0];
	public Magnum() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		s.learnSkill(test);
		return enchantment;
	}
	
	public void unEnchantment(Schmuck s) {
		s.forgetSkill(test);		
	}
	
	public boolean isLegendary(){
		return true;
	}
}
