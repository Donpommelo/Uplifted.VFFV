package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ExtraTurn;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Unhealthy;

public class TunzoFunFries extends Item{

	static int id = 95;
	static String name = "Tunzo Funfries";
	static boolean menu = false;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 10;
	static int slot = 0;
	static int lvlReq = 12;
	static String descr="The only possible accompaniment to a Tunzo Funburger. Food like this makes you wonder how the company manages such a low rate of obesity.";
	static String descrShort="Restores Hp to user./Free Action/Makes you feel unhealthy";
	public TunzoFunFries() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		if(bs.bp.stm.checkStatus(perp, new Unhealthy(perp,50))){
			bs.gs.inventorymanager.loot(this, 1);
			bs.bp.bt.addScene(perp.getName()+" feels too gross and unhealthy to eat any more "+this.getName());
		}
		else{
			bs.bp.em.hpChange(25, perp, perp, 6);
			bs.bp.stm.addStatus(perp, new Unhealthy(3, perp, perp, 50));
			bs.bp.TurnOrderQueue.add(1,new Action(perp,perp,new ExtraTurn(0),bs));
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" munches on some Tunzo Funfries!";
	}
	
	public int getTargetType(){
		return 1;
	}
}