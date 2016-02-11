package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FestusClawStatus extends status{

	public FestusClawStatus(int pr){
		super("Claws of Festus Status", pr);
	}
	public void PreActionUser(Schmuck s, Action a, BattleState bs){
		if(!a.skill.getName().equals("Item") && !a.skill.getName().equals("Dilly Dally") && !a.skill.getName().equals("Run Away")&& !a.skill.getName().equals("Pass Turn")){
			if(bs.bp.calcCrit(a)){
				bs.bp.stm.addStatus(s, new BonusStatBuff(0,16,10,s,100));
			}
			else{
				bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to do something, but no one was listening."),bs));
			}
		}
	}	
}
