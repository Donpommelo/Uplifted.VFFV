package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Delicious extends status{
	
	public int duration;
	public double percent;
	public Boolean perm = false;
	public Boolean visible = true;
	public Delicious(int i, double percent, Schmuck perp){
		super(i, "Delicious", false, false, true, perp);
		this.percent = percent;
	}
	
	public Delicious(double percent, Schmuck perp){
		super("Delicious", false, false, perp);
		this.percent = percent;
	}
	
	
	public void takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.textList.add(perp.getName()+" looks replenished.");
		bs.bp.em.hpChange((int)(damage*percent), vic, perp);
	}	
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks more delicious!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" doesn't look delicious anymore.";
	}
	
	public int getDuration(){
		return duration;
	}

}
