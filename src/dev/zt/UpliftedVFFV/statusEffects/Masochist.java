package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Masochist extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public Masochist(int i, double percent, Schmuck perp){
		super(i, "Masochist", false, false, true, perp);
		this.percent = percent;
	}
	
	public Masochist(double percent, Schmuck perp){
		super("Masochist", false, true, perp);
		this.percent = percent;
	}
	
	
	public void takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		if(damage >= vic.getMaxHp()*.1){
			bs.bp.bt.textList.add(vic.getName()+" seems to be enjoying it!");
			vic.bpChange((int)(damage*percent));
		}		
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is masochistic!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer masochistic.";
	}
	
	public int getDuration(){
		return duration;
	}

}