package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SportsmanshipAwardStatus extends status{
	
	public static String name = "Sportsmanshiply";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public SportsmanshipAwardStatus(int i, Schmuck perp, Schmuck vic,int pr){
		super(i, name, perm, visible, removedEnd, decay, perp,vic, pr);
	}
	
	public SportsmanshipAwardStatus(int pr){
		super(name, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(bs.bp.getSelectableEnemies(s).contains(a.getTarget()) && a.getSkill().targetType == 0){
			for(status st : a.getTarget().statuses){
				if(st.isDisable()){
					bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+"'s Sportsmanship Award prevented "+s.getPronoun(1)+" from targeting an enemy that is affected by "+st.getName()+"!"),bs));
					break;
				}
			}
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" began exhibiting Sportsmanship.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer showing Sportsmanship.";
	}
	
}
