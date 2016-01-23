package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EchoShellStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class EchoShell extends Item{

	static int id = 2;
	static String name = "Echo Shell";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 28;
	static String descr="A mysterious sea shell. It sounds almost like the ocean, but not quite.";
	static String descrShort = "Echoes end-of-turn effects.";
	public status[] enchantment = new status[2];
	public EchoShell() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EchoShellStatus(40);
		enchantment[1] = new StatBuffAdd(3,(int)(11*(1+s.getEquipPow())), 40);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
