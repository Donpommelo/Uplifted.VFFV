package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class FennelDonut extends Item{

	static int id = 1;
	static String name = "Fennel Off-Gazpacho Donut";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 5;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="Mick always had the worst taste in donuts.";
	static String descrShort="Restore Hp.";
	public FennelDonut() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(60*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp,vic,6);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" eats a nasty, nasty donut.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a nasty, nasty donut.";
		}
	}
		
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(60*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, "Its one nasty donut, but it restores Hp nonetheless.", 0));
	}
}
