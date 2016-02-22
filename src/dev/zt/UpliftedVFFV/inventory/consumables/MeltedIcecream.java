package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;

public class MeltedIcecream extends Item{

	static int id = 2;
	static String name = "Melted Ice Cream";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 18;
	static int slot = 0;
	static int lvlReq = 2;
	static String descr="A bottle of lukewarm cream soda.";
	static String descrShort="Restore Hp.";
	public MeltedIcecream() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(.5*(vic.getMaxHp()-vic.getCurrentHp())),perp,vic,6);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" drinks/eats a Melted Icecream.";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Melted Icecream.";
		}
	}
	
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(.5*(s.getMaxHp()-s.getCurrentHp())));
		StateManager.states.push(new NotificationState(game, gs, sm, "The frozen slush restores health to "+s.getName()+"!", 0));
	}
}
