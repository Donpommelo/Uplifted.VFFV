package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;


public class CoffeeBean extends Item{

	static int id = 26;
	static String name = "Roasted Coffee Bean";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 3;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A fragrant, roasted coffee bean.";
	static String descrShort="Restore Mp.\nCaution: Hot!";
	public CoffeeBean() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.addScene("The Coffee Bean scalds "+vic.getName()+"'s tongue!");
		bs.bp.em.hpChange(-30,perp,vic,0);
		bs.bp.em.bpChange((int)(80*(1+perp.getItemPow())*(1+vic.getRegenBonus())),vic);

	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" pops a Coffee bean into "+vic.getPronoun(3)+" mouth.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Coffee Bean.";
		}
	}
		
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange(-30);
		s.bpChange((int)(80*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, s.getName()+" consumes the coffee bean. Refreshing, but hot!", 0));
	}
	
	
}
