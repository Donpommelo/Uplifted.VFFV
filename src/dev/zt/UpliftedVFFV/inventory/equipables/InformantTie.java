package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.OrangeInfusion;

public class InformantTie extends Item{

	static int id = 2;
	static String name = "Informant's Tie";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 3950;
	static int slot = 1;
	static int lvlReq = 46;
	static String descr="An enchanted tie of an indescribable color.";
	static String descrShort="Adds 8 damage to every instance of damage dealt.";
	public status[] enchantment = new status[1];
	public InformantTie() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new OrangeInfusion(s,0);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
