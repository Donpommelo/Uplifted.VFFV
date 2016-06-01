package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.ExtraTurn;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class Plopcorn extends Item{

	static int id = 95;
	static String name = "Plopcorn";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 50;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A doomed attempt at popcorn soup. Makes 'plop' sounds when served.";
	static String descrShort="Restore very little Hp.\nFree Action";
	public Plopcorn() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(3,perp,vic,6);
		bs.bp.TurnOrderQueue.add(1,new Action(perp,perp,new ExtraTurn(0),bs));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" plops the plopcorn in "+vic.getPronoun(3)+" mouth!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" some Plopcorn.";
		}
	}
		
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange(3);
		StateManager.states.push(new NotificationState(game, gs, sm, s.getName()+" eats the Plopcorn. Not very satisfying.", 0));
	}
}
