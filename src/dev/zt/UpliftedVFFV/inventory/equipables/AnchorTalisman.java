package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.DamageBlock;
import dev.zt.UpliftedVFFV.statusEffects.StoneSkin;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AnchorTalismanStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class AnchorTalisman extends Item{

	static int id = 2;
	static String name = "Anchor Talisman";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="+10% Def\nImmune to one-hit-kills";
	public status[] enchantment = new status[2];
	public AnchorTalisman() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AnchorTalismanStatus(10);
		enchantment[1] = new StatBuffMult(3, 1.1*(1+s.getEquipPow()),30);
		return enchantment;
	}
}
