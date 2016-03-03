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
	static int value = 5;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A container of useful medicines. The Infirmary distributes\nthese to other floors to avoid having to actually see any of\nyour faces.";
	static String descrShort="Restore Hp.";
	public MedPak() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(50*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp, vic,6);
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(50*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, "A Medpak is administered to "+s.getName()+"!", 0));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" uses a Medpak on "+vic.getPronoun(3)+"self!";
		}
		else{
			return perp.getName()+" uses a Medpak on "+vic.getName()+"!";
		}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}

}
