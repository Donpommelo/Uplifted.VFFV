package dev.zt.UpliftedVFFV.inventory;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.EchoShellStatus;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EchoShell extends Item{

	static String descr="A mysterious sea shell. It sounds almost like the ocean, but not quite.";
	static String descrShort = "Echoes end-of-turn effects.";
	public status[] enchantment = new status[1];
	public EchoShell() {
		super(2, "Echo Shell",false, false, false, false,descr, descrShort,800,1);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EchoShellStatus(s.getItemDummy(),40);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
