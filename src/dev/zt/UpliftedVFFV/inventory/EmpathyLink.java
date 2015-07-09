package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.EmpathyLinkStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EmpathyLink extends Item{

	static String descr="This is a link between the emotions of very close friends.";
	static String descrShort = "Equalizes the Hp of living allies after every round.";
	public status[] enchantment = new status[1];
	public EmpathyLink() {
		super(2, "Empathy Link",false, false, false, false, true, descr, descrShort);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EmpathyLinkStatus(s.getItemDummy(),5);
		return enchantment;
	}

	
}
