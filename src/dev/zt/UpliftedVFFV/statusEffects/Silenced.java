package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Silenced extends status{
	
	public static String name = "Silence";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Silenced(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Silenced(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.getSkill().silenceBlocked()){
			if(a.skill.getName().equals("")){
				bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to use an ability but was Silenced."),bs));

			}
			else{
				bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" tried to use "+a.skill.getName()+" but was Silenced!"),bs));
			}
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" was Silenced and cannot perform Special Skills!";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s voice came back!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
