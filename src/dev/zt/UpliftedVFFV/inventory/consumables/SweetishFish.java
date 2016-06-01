package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;

public class SweetishFish extends Item{

	static int id = 89;
	static String name = "Sweetish Fish";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 40;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A bag of colorful fish-shaped (flavored?) candy.";
	static String descrShort="Restores Hp to user.\nBoosts random elemental points.";
	public SweetishFish() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(50*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp, vic,6);
		for(int i = 1; i < 4; i++){
			int rand = (int)(Math.random()*5);
			bs.bp.stm.addStatus(vic, new ElemPointsBuff(5, rand, (int)(15 * (1 + perp.getItemPow())), perp,vic,5));
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return vic.getName()+" eats a bag of Sweetish Fish!";
	}
	
	public int getTargetType(){
		return 1;
	}
}
