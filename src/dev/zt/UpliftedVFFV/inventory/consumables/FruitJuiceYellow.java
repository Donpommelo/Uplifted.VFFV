package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FruitJuiceYellow extends Item{

	static int id = 95;
	static String name = "Yellow Fruit Juice";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 35;
	static int slot = 0;
	static int lvlReq = 5;
	static String descr="A bottle of juice from a yellow fruit. Based on taste alone, employees are torn between pineapple and starfruit.";
	static String descrShort="Boosts Yellow Resistance";
	public FruitJuiceYellow() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3,22,0.5,perp,vic,25));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks a Yellow Fruit Juice!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Yellow Fruit Juice!";
		}
	}
}
