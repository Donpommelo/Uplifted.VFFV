package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FruitJuiceBlue extends Item{

	static int id = 95;
	static String name = "Blue Fruit Juice";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 35;
	static int slot = 0;
	static int lvlReq = 5;
	static String descr="A bottle of juice from a blue fruit. Most employees imagine blueberries, but it is actually agave.";
	static String descrShort="Boosts Blue Resistance";
	public FruitJuiceBlue() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3,20,0.5,perp,vic,25));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks a Blue Fruit Juice!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Blue Fruit Juice!";
		}
	}
}
