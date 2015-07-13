package dev.zt.UpliftedVFFV.statusEffects;


import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PrehistSynapse extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int damage = 0;
	public int hp;
	public PrehistSynapse(int i, Schmuck perp){
		super(i, "Delayed Response", false, false, true, perp);
	}
	
	public PrehistSynapse(Schmuck perp, int pr){
		super("Delayed Response", false, false, perp,pr);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		hp = s.getCurrentHp();
	}
		
	public void takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		bs.bp.bt.textList.add(vic.getName()+"'s Prehistoric Synapse delays damage!");
		this.damage+=damage;
	}
	
	public void endofAnyAction(BattleState bs, Action a, Schmuck s){
		s.setCurrentHp(hp);
		if(bs.bp.stm.checkStatus(s, new incapacitate(s))){
			bs.bp.stm.removeStatus(s, new incapacitate(s));
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Prehistoric Synapse inflicted delayed damage!");
		s.hpChange(damage);
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+" looks stoic!";

	}

	public String cureText(Schmuck s){
		return s.getName()+" looks normal again.";
	}
	
	public int getDuration(){
		return duration;
	}

}
