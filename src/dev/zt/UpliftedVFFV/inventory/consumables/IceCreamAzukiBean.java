package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class IceCreamAzukiBean extends Item{

	static int id = 95;
	static String name = "Azuki Bean Ice Cream";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 15;
	static int slot = 0;
	static int lvlReq = 1;
	static String descr="TEMP";
	static String descrShort="Restore Hp and buff Pow.";
	public IceCreamAzukiBean() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
		
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(40*(1+perp.getItemPow())*(1+vic.getRegenBonus())),perp,vic,6);
		bs.bp.stm.addStatus(vic, new StatBuffMult(4, 2, 1.2, perp, vic, 50));
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		if(perp.getName().equals(vic.getName())){
			return vic.getName()+" eats a Azuki Bean Ice Cream!";
		}
		else{
			return perp.getName()+" gives "+vic.getName()+" a Azuki Bean Ice Cream!";
		}
	}
		
	public void use(Schmuck s,Game game, StateManager sm,GameState gs){
		s.hpChange((int)(40*(1+s.getItemPow())*(1+s.getRegenBonus())));
		StateManager.states.push(new NotificationState(game, gs, sm, s.getName()+" eats the delicious ice cream.", 0));
	}
}
