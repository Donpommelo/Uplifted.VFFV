package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.AkadamaOrbStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class AkadamaOrb extends Item{

	static int id = 95;
	static String name = "Akadama Orb";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 150;
	static int slot = 1;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="User is immune on own turn.\n+8 Red and Green Alignment Points.";
	public status[] enchantment = new status[3];
	public AkadamaOrb() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new AkadamaOrbStatus(s,50);
		enchantment[1] = new ElemPointsBuff(0, 8, s,31);
		enchantment[2] = new ElemPointsBuff(2, 8, s,31);

		return enchantment;
	}
}
