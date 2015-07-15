package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class AbsoluteThresholdStatus extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public AbsoluteThresholdStatus(int i, double percent, Schmuck perp){
		super(i, "Damage Ignore", false, false, true, perp);
		this.percent = percent;
	}
	
	public AbsoluteThresholdStatus(double percent, Schmuck perp){
		super("Damage Ignore", false, false, perp);
		this.percent = percent;
	}
	
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(damage <= percent * vic.getMaxHp()){
			bs.bp.bt.textList.add(vic.getName()+"'s Absolute Threshold blocks damage!");
			return 0;
		}
		else{
			return damage;
		}
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" is ignoring damage!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" is not longer ignoring damage.";
	}
	
	public int getDuration(){
		return duration;
	}

}
