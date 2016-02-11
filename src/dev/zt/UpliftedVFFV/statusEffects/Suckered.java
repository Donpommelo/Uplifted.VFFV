package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Suckered extends status{
	
	public static String name = "Suckered";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public Schmuck puncher;	
	public Suckered(int pr, Schmuck perp){
		super(name, pr);
		this.puncher = perp;
	}
	
	public void onMiss(Schmuck s, Action a, BattleState bs){
		bs.bp.bt.addScene(puncher.getName()+" sucker punches "+s.getName()+" when he misses!");
		bs.bp.em.hpChange(-(puncher.getBuffedPow()*puncher.getBuffedPow())/s.getBuffedDef(), puncher, s, 6);
	}
		
}
