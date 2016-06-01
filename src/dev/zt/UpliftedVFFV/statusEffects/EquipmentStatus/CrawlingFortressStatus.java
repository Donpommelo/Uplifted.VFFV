package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CrawlingFortressStatus extends status{

	public CrawlingFortressStatus(Schmuck v,int pr){
		super("Bombarding", v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Attack")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tries to attack out of "+s.getPronoun(1)+" Crawling Fortress but is unable to!"),bs));
		}
		if(a.skill.silenceBlocked()){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tries to use an ability from inside of "+s.getPronoun(1)+" Crawling Fortress, but fails!"),bs));
		}
	}
	
}
