package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MeterShield extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public MeterShield(int i, double percent, Schmuck perp){
		super(i, "Damage Reflect", false, false, true, perp);
		this.percent = percent;
	}
	
	public MeterShield(double percent, Schmuck perp){
		super("Damage Reflect", false, false, perp);
		this.percent = percent;
	}

	public void statchanges(Schmuck s){
		s.bonusStats[8]+=percent;

	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.textList.add(vic.getName()+"'s Faraday Cage absorbs damage!");
		bs.bp.em.bpChange((int)(damage*percent),vic);
		return (int)(damage *(1-percent));
	}
	
	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is reflecting damage!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer reflecting damage.";
	}
	
	public int getDuration(){
		return duration;
	}

}
