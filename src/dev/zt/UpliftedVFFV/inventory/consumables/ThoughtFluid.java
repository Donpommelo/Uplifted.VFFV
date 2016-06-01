package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class ThoughtFluid extends Item{

	static int id = 44;
	static String name = "Thought Fluid";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 4;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A bottle of liquified thoughts. A bottle this concentrated is bound to contain a good idea or two.";
	static String descrShort="Buffs Int and Mp Regen";
	public ThoughtFluid() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new StatBuffMult(3, 6, 1.25*(1+perp.getItemPow()), perp,vic, 30));
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 35, 7*(1+perp.getItemPow()), perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" considers a Thought Fluid!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Thought Fluid!";
		}
	}
}
