package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CrawlingFortressStatus extends status{

	public CrawlingFortressStatus(int pr){
		super("Bombarding", pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Attack")){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" cannont attack out of "+s.getPronoun(1)+" Crawling Fortress!"),bs));
		}
		if(a.skill.silenceBlocked()){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" cannont use skills from inside of "+s.getPronoun(1)+" Crawling Fortress!"),bs));
		}
	}
	
}
