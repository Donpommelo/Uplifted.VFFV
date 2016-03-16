package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Fear extends status{
	
	public static String name = "Fear";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Schmuck Frighter;
	public Fear(int i, Schmuck perp, Schmuck vic, Schmuck frighter, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.Frighter = frighter;
	}
	
	public Fear(int pr){
		super(name, pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.getTarget() == Frighter && a.getSkill().getTargetType() ==0){
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+" too Fearful to target "+Frighter.getName()+"!"),bs));
		}
	}

	public String inflictText(Schmuck s){
		return s.getName()+" became Afraid of "+ Frighter.getName()+"!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Afraid of "+ Frighter.getName()+"!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
