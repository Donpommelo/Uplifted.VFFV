package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Berzerk extends status{
	
	public static String name = "Berserk";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Berzerk(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Berzerk(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(Math.random() < .75 && a.getSkill().getTargetType() == 0){
			Schmuck newTarget = bs.bp.battlers.get((int)(Math.random()*bs.bp.battlers.size()));
			if(bs.bp.stm.checkStatus(newTarget, new incapacitate(newTarget,newTarget))){
				a.target = newTarget;
				bs.bp.bt.addScene(s.getName()+" is going Berserk!");
				bs.bp.bt.addScene(s.getName()+" targeted a random character!");
			}
		}
		
	}

	public String inflictText(Schmuck s){
		return s.getName()+" went Berserk and might target the wrong character!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" calmed down and is no longer Berserk!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
