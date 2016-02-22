package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Asleep;


public class CoffeedIce extends Item{

	static int id = 2;
	static String name = "Coffee'd Ice";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 22;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A thermos of shaved ice with some faint coffee flavoring.";
	static String descrShort="Restore Hp and Mp.\nCures Sleep";
	public CoffeedIce() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new Asleep(50));
		bs.bp.em.hpChange((int)(15*(1+perp.getItemPow())),perp, vic,6);
		bs.bp.em.bpChange((int)(25*(1+perp.getItemPow())),vic);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" imbibes the Coffee'd Ice.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" Coffee'd Ice.";
		}
	}
		
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(25*(1+s.getItemPow())));
		s.bpChange((int)(35*(1+s.getItemPow())));
		StateManager.states.push(new NotificationState(game, gs, sm, "The coffee Motivates "+s.getName()+" and the ice heals wounds!", 0));
	}

}
