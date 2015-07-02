package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PennyBlueStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
//	public BattleState bs;
	public PennyBlueStatus(int i, Schmuck perp){
		super(i, "Penny Blue", false, true, true, perp);
//		this.bs = bs;
	}
	
	
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Penny Blue regenerates vitality.");
		bs.bp.em.hpChange((int)((s.getMaxHp()/10)*(1+perp.getHealPower())),perp,s);
		bs.bp.em.bpChange(s.getMaxBp()/10,s);		
	}

	public void statchanges(Schmuck s){
		s.buffedRes[0]+=.3;
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+" became infused with Blue energy.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Blue energy wore off.";
	}
	
	public int getDuration(){
		return duration;
	}

}
