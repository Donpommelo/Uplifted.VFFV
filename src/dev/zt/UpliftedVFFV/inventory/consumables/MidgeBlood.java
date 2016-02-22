package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class MidgeBlood extends Item{

	static int id = 2;
	static String name = "Midge Blood";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 3;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="Blood from a midge could really be anybody's.";
	static String descrShort="Regenerate Hp over time.";
	public MidgeBlood() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3,34,(int)(8*(1+perp.getItemPow())), perp, 40));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks the Midge Blood.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" the Midge Blood.";
		}
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(10*(1+s.getItemPow())));
		StateManager.states.push(new NotificationState(game, gs, sm, "The transfusion restores Hp to "+s.getName()+"!", 0));
	}
}
