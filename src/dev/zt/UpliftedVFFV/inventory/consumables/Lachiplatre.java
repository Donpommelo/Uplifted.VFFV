package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class Lachiplatre extends Item{

	static int id = 2;
	static String name = "Lachiplatre";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 0;
	static int slot = 0;
	static int lvlReq = -1;
	static String descr="A stale, bun-like object stuffed with dry paste. You assume\nit is edible.";
	static String descrShort="Eat it. I guess.";
	public Lachiplatre() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(2, perp, vic,6);
		bs.bp.em.bpChange(2,vic);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" eats the Lachiplatre.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" the Lachiplatre.";
		}
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange(2);
		s.bpChange(2);
		StateManager.states.push(new NotificationState(game, gs, sm, "The Lachiplatre tastes like nothing . . . yet tastes familiar . . .", 0));
	}
}
