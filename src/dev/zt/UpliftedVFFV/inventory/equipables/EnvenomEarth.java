package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.Envenomed;

public class EnvenomEarth extends Item{

	static int id = 2;
	static String name = "Envenomed Earth";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 300;
	static int slot = 1;
	static int lvlReq = 9;
	static String descr="Something probably died on this.";
	static String descrShort = "Poisons user and makes tougher. Eventually";
	public int points = 0;
	public status[] enchantment = new status[1];
	public EnvenomEarth() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new Envenomed(.15, this, 1);
		return enchantment;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}	
}
