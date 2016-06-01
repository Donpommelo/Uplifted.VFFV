package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FruitJuiceRed extends Item{

	static int id = 95;
	static String name = "Red Fruit Juice";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 35;
	static int slot = 0;
	static int lvlReq = 5;
	static String descr="A bottle of juice from a red fruit. Technically, tomato is a fruit.";
	static String descrShort="Boosts Red Resistance";
	public FruitJuiceRed() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3,19,0.5,perp,vic,25));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks a Red Fruit Juice!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Red Fruit Juice!";
		}
	}
}
