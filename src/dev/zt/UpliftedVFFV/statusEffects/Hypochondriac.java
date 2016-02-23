package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Hypochondriac extends status{
	
	public static String name = "Hypochondria";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Hypochondriac(int i,Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Hypochondriac(int pr){
		super(name, pr);
	}

	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.isBad() && st.getName() != "Hypochondria"){
			bs.bp.bt.addScene(s.getName()+"'s Hypochondria was triggered!");
			st.setDuration((int)(st.getDuration()*1.5));
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became a Hypochondriac and is more susceptible to debuffs!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer a Hypochondriac";
	}
	
	public Boolean isBad(){
		return true;
	}
}
