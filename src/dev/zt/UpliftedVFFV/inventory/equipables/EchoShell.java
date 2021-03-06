package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.EchoShellStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffAdd;

public class EchoShell extends Item{

	static int id = 42;
	static String name = "Echo Shell";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 28;
	static String descr="A mysterious sea shell. It sounds like the ocean. Whatever that sounds like.";
	static String descrShort = "+11 Def\nEchoes end-of-turn effects.";
	public status[] enchantment = new status[2];
	public EchoShell() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new EchoShellStatus(s,100);
		enchantment[1] = new StatBuffAdd(3,11, s,45);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
	
}
