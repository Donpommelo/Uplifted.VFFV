package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class SaltedNori extends Item{

	static int id = 94;
	static String name = "Salted Nori";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 85;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="A bag of salty seaweed snack. Goes well with just about anything!";
	static String descrShort="Restores Hp to user.\nIncreases user's regeneration bonus";
	public SaltedNori() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(70*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp,vic,6);
		bs.bp.stm.addStatus(vic, new BonusStatBuff(5, 29, (int)(.40 * (1 + perp.getItemPow())), perp,vic,5));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" eats some Salted Nori!";
	}
	
	public int getTargetType(){
		return 1;
	}
}
