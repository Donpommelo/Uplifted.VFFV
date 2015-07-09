package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Haunt;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DeadMansHandStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public DeadMansHandStatus(int i, Schmuck perp){
		super(i, "Haunting", false, false, true, perp);
	}
	
	public DeadMansHandStatus(Schmuck perp, int pr){
		super("Haunting", false, false, perp,pr);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		if(bs.bp.stm.checkStatus(s, new incapacitate(s))){
			bs.bp.TurnOrderQueue.add(new Action(s, s, new Haunt(0), bs));
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks ghostly!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" looks normal again.";
	}
	
	public int getDuration(){
		return duration;
	}

}
