package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Ablaze extends status{
	
	public static String name = "Ablaze";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Ablaze(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Ablaze(int pr){
		super(name, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+" continues to immolate.");
		bs.bp.em.hpChange(-4,perp,s,0);	
	}

	public void statchanges(Schmuck s){
		s.bonusStats[19]-=.2;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" was set on fire!";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s fire was extinguished!";
	}
	
	public Boolean isBad(){
		return true;
	}
}
