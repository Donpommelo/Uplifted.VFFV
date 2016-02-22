package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class LemonyFresh extends Item{

	static int id = 2;
	static String name = "Lemony Fresh";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 24;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A can of translucent liquid. It is either the tastiest detergent\nor the most antiseptic energy drink on the market.";
	static String descrShort="Restore Hp and Bp and shorten duration of statuses.";
	public LemonyFresh() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(15*(1+perp.getItemPow())), perp, vic,6);
		bs.bp.em.bpChange((int)(15*(1+perp.getItemPow())),vic);
		for(status s: vic.statuses){
			if(!s.perm){
				s.setDuration(s.getDuration()/2);
			}
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks a bottle of Lemony Fresh.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a bottle of Lemony Fresh.";
		}
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(25*(1+s.getItemPow())));
		s.bpChange((int)(15*(1+s.getItemPow())));
		StateManager.states.push(new NotificationState(game, gs, sm, s.getName()+" drinks the refreshing beverage!", 0));
	}
}
