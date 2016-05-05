package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.RingofGygesStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class RingofGyges extends Item{

	static int id = 42;
	static String name = "Ring of Gyges";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 1150;
	static int slot = 1;
	static int lvlReq = 38;
	static String descr="A humble piece of jewelry that prevents visibility from being a deterrent to acts of treachery.";
	static String descrShort = "Grants Invisibility at low Health\n+12% Evasion Chance";
	public status[] enchantment = new status[2];
	public RingofGyges() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new RingofGygesStatus(s,40);
		enchantment[1] = new BonusStatBuff(1,.12*(1+s.getEquipPow()), s,50);
		return enchantment;
	}
	
	public boolean isLegendary(){
		return true;
	}
}
