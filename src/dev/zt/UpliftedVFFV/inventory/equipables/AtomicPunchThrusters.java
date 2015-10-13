package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.ExplosiveCrit;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class AtomicPunchThrusters extends Item{

	static int id = 2;
	static String name = "Atomic Punch-Thrusters";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 800;
	static int slot = 1;
	static int lvlReq = 34;
	static String descr="";
	static String descrShort="Explosive Crits!";
	public status[] enchantment = new status[2];
	public AtomicPunchThrusters() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new ExplosiveCrit((int)(s.getBuffedPow()*(1+s.getEquipPow())),s.itemDummy, 75);
		enchantment[1] = new BonusStatBuff(16,(int)(.15*(1+s.getEquipPow())),s.itemDummy,75);
		return enchantment;
	}
}
