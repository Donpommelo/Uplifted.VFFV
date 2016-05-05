package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.OriginCoilStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class OriginCoil extends Item{

	static int id = 42;
	static String name = "Origin Coil";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 630;
	static int slot = 1;
	static int lvlReq = 30;
	static String descr = "A complex apparatus simulating the conditions of life's first inception.";
	static String descrShort="+5Hp and Mp regen.\nOn Wait; Heal allies.\nRequires cooldown.";
	public status[] enchantment = new status[3];
	public OriginCoil() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
		
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new OriginCoilStatus(s,50);
		enchantment[1] = new BonusStatBuff(34,5*(1+s.getEquipPow()),s,50);
		enchantment[2] = new BonusStatBuff(35,5*(1+s.getEquipPow()),s,50);
		return enchantment;
	}

}
