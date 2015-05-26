package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Ablaze extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
//	public BattleState bs;
	public Ablaze(int i){
		super(i, "Ablaze", true);
//		this.bs = bs;
	}
	
	
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+" continues to immolate.");
		bs.bp.em.hpChange(-4,s,0);	
	}

	public void statchanges(Schmuck s){
		s.buffedRes[0]-=.2;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was set on fire.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s fire was extinguished.";
	}
	
	public int getDuration(){
		return duration;
	}

}
