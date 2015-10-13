package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.Undead;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DeadMansHandStatus;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class DeadMansHand extends Item{

	static int id = 2;
	static String name = "Dead Man's Hand";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 850;
	static int slot = 1;
	static int lvlReq = 28;
	static String descr="The hand of a dead man.";
	static String descrShort = "Haunts enemies when user is dead.";
	public status[] enchantment = new status[3];
	public DeadMansHand() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new DeadMansHandStatus(s.getItemDummy(),80);
		enchantment[1] = new Undead(s.getItemDummy(),80);
		enchantment[1] = new ElemPointsBuff(4,(int)(10*(1+s.getEquipPow())), s.itemDummy,50);
		return enchantment;
	}

	public boolean isLegendary(){
		return true;
	}
}
