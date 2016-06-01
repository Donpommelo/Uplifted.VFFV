package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Invisible;

public class CrystalDumplings extends Item{

	static int id = 95;
	static String name = "Crystal Dumplings";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 15;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="A pan of dumplings made with clear jelly-like wrapping. The transparency of the dish is meant to reassure customers of the quality of the filling.";
	static String descrShort="Restore Hp and grants 1-Turn invisibility to target.";
	public CrystalDumplings() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(60*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp,vic,6);
		bs.bp.stm.addStatus(vic, new Invisible(1, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" eats a plate of Crystal Dumplings!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a plate of Crystal Dumplings!";
		}
	}
		
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(60*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, s.getName()+" chews on the nutritious dumplings.", 0));
	}
}
