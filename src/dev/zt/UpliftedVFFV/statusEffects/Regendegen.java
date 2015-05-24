package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Regendegen extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public Boolean HpBp;
//	public BattleState bs;
	public int regen;
	public Regendegen(int i, Boolean stat, int amount){
		super(i, "Regeneration", true);
		this.HpBp = stat;
		this.regen = amount;
	}
	
	public Regendegen(Boolean stat, int amount){
		super("Regeneration");
		this.HpBp = stat;
		this.regen = amount;
	}
	
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(HpBp){
			bs.bp.em.hpChange(6,s);;
		}
		else{
			bs.bp.em.bpChange(6,s);
		}
	}

	
	public String inflictText(Schmuck s){
		String plus = "degenerating";
		String Hpbp = "Bp";
		if(regen>0){
			plus = "regenerating";
		}
		if(HpBp){
			Hpbp = "Hp";
		}
		return s.getName()+" is "+plus+" "+Hpbp+".";

	}

	public String cureText(Schmuck s){
		return s.getName()+" stopped regenerating.";
	}
	
	public int getDuration(){
		return duration;
	}

}
