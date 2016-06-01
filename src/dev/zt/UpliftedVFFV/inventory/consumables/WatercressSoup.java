package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class WatercressSoup extends Item{

	static int id = 95;
	static String name = "Watercress Soup";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 35;
	static int slot = 0;
	static int lvlReq = 5;
	static String descr="TEMP";
	static String descrShort="Restores Hp to target.\nScales to user's Blue and Green Alignment Points.";
	public WatercressSoup() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		int heal = perp.getBluePoints() + perp.getGreenPoints();
		bs.bp.em.hpChange((int)(heal*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp, vic,6);

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks a Watercress Soup!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Watercress Soup!";
		}
	}
}
