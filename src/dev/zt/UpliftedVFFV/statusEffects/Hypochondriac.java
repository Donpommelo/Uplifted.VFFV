package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Hypochondriac extends status{
	
	public static String name = "Hypochondriac";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Hypochondriac(int i,Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public Hypochondriac(int pr){
		super(name, pr);
	}

	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.isBad()){
			bs.bp.bt.addScene(s.getName()+"'s Hypochondria was triggered!");
			st.setDuration((int)(st.getDuration()*1.5));
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became Hypochondriac!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Hypochondriac";
	}
	
	public Boolean isBad(){
		return true;
	}
}
