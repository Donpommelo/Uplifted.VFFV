package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PainGateStatus extends status{
	
	public int duration;

	public Boolean perm = false;
	public Boolean visible = true;
	public PainGateStatus(int i, Schmuck perp){
		super(i, "Damage Round", false, false, true, perp);

	}
	
	public PainGateStatus(Schmuck perp){
		super("Damage Round", false, false, perp);

	}
	
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if((-damage)%20 <= 10){
			return damage - damage%20;
		}
		else{
			return damage - damage%20 - 20;
		}
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is rounding damage!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer rounding damage.";
	}
	
	public int getDuration(){
		return duration;
	}

}
