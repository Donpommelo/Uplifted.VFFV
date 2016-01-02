package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Berzerk extends status{
	
	public static String name = "Berzerk";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Berzerk(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Berzerk(int pr){
		super(name, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(Math.random() < .75){
			Schmuck newTarget = bs.bp.battlers.get((int)(Math.random()*bs.bp.battlers.size()));
			if(bs.bp.stm.checkStatus(newTarget, new incapacitate(newTarget))){
				a.target = newTarget;
				bs.bp.bt.textList.add(s.getName()+" is going Berzerk!");
				bs.bp.bt.textList.add(s.getName()+" targeted a random character!");
			}
		}
		
	}

	public String inflictText(Schmuck s){
		return s.getName()+" went Berzerk.";
	}

	public String cureText(Schmuck s){
		return s.getName()+" calmed down.";
	}
	
	public Boolean isBad(){
		return true;
	}
}
