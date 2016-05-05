package dev.zt.UpliftedVFFV.inventory.equipables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class InfernalRacket extends Item{

	static int id = 42;
	static String name = "Infernal Racket";
	static boolean menu = false;
	static boolean battle = false;
	static boolean consume = false;
	static boolean target = false;
	static int value = 35;
	static int slot = 1;
	static int lvlReq = 5;
	static String descr="A tennis racket that produces really annoying noises whenever swung.";
	static String descrShort="+11 Red Points\n+1 Monster Level";
	public status[] enchantment = new status[2];
	public InfernalRacket() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);
	}
	
	public status[] getEnchantment(Schmuck s) {
		enchantment[0] = new BonusStatBuff(11,1,s, 50);
		enchantment[1] = new ElemPointsBuff(0,(int)(11*(1+s.getEquipPow())),s, 50);
		return enchantment;
	}
}
