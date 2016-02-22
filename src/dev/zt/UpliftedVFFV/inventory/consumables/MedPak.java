package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class MedPak extends Item{

	static int id = 2;
	static String name = "Med-Pak";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 10;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A container of useful medicines. The Infirmary distributes\nthese to other floors to avoid having to actually see any of\nyour faces.";
	static String descrShort="Restore Hp.";
	public MedPak() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(20*(1+perp.getItemPow())),perp, vic,6);
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(30*(1+s.getItemPow())));
		StateManager.states.push(new NotificationState(game, gs, sm, "The Medpak is administered to "+s.getName()+"!", 0));
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}

}
