package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PennyBlueStatus extends status{
	
	public static String name = "Penny Blue";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public PennyBlueStatus(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Penny Blue regenerates vitality.");
		bs.bp.em.bpChange(s.getMaxBp()/10,s);		
	}

	public void statchanges(Schmuck s){
		s.buffedElemPoints[1]+=10;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became infused with Blue energy.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Blue energy wore off.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
