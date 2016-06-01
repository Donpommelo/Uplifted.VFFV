package dev.zt.UpliftedVFFV.inventory.consumables;

import dev.zt.UpliftedVFFV.Game;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.states.GameState;
import dev.zt.UpliftedVFFV.states.NotificationState;
import dev.zt.UpliftedVFFV.states.StateManager;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;

public class SmellingSalt extends Item{

	static int id = 12;
	static String name = "Smellingsalt";
	static boolean menu = true;
	static boolean battle = true;
	static boolean consume = true;
	static boolean target = true;
	static int value = 12;
	static int slot = 0;
	static int lvlReq = 5;
	static String descr="A package of chemicals used in reviving overworked or dead coworkers.";
	static String descrShort="Revives target.";
	public SmellingSalt() {
		super(id,name,menu,battle,consume,target,descr,descrShort,value,slot,lvlReq);

	}
	
	public void use(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.removeStatus(vic, new incapacitate(vic,vic) );
		bs.bs.targetUpdate();
		bs.bp.em.hpChange((int)(5*(1+perp.getItemPow())*(1+vic.getRegenBonus())), perp, vic,6);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return perp.getName()+" administers the Smellingsalt to "+vic.getName();
	}
	
	public void use(Schmuck s, Game game, StateManager sm,GameState gs){
		s.hpChange(5);
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i).getName()!=null){
				if(s.statuses.get(i).getName().equals("incapacitated")){
					s.statuses.remove(i);
					i--;
				}
			}
		}
		StateManager.states.push(new NotificationState(game, gs, sm, s.getName()+" looks refreshed!", 0));
	}
	
	public int getTargetType(){
		return 2;
	}

}
