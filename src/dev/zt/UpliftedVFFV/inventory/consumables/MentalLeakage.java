package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class MentalLeakage extends Item{

	static int id = 2;
	static String name = "Mental Leakage";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 3;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A handful of loose thoughts. You doubt it contains anything\nuseful.";
	static String descrShort="Restore Mp.";
	public MentalLeakage() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.bpChange((int)(45*(1+perp.getItemPow())*(1+vic.getRegenBonus())),vic);
		bs.bp.bt.addScene("Some of the the thoughts restore Mp!");
		if(Math.random()<.1){
			//get some terrible side effect.
		}
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" considers the Mental Leakage!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Mental Leakage!";
		}
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.bpChange((int)(45*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, "Some of the stray thoughts restore "+s.getName()+"'s Motivation!", 0));
	}
}
