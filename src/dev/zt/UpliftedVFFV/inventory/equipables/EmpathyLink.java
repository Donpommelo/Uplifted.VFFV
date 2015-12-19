package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EmpathyLinkStatus;

public class EmpathyLink extends Item{

	static int id = 2;
	static String name = "Empathy Link";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1000;
	static int slot = 1;
	static int lvlReq = 40;
	static String descr="This is a link between the emotions of very close friends.";
	static String descrShort = "Equalizes the Hp of living allies after every round.";
	public status[] enchantment = new status[1];
	public EmpathyLink() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EmpathyLinkStatus(5);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
