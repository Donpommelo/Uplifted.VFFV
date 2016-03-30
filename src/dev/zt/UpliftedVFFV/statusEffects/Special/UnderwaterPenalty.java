package dev.zt.UpliftedVFFV.statusEffects.Special;

import dev.zt.UpliftedVFFV.Battle.Animations.PoisonAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.incapacitate;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class UnderwaterPenalty extends status{
	
	public static String name = "Underwater";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = false;
	public static Boolean decay = false;
	public Schmuck inflicter;
	public UnderwaterPenalty(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.inflicter = perp;
	}
	
	public UnderwaterPenalty(Schmuck v,int pr){
		super(name, v,pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		for(Schmuck schm : bs.bp.battlers){
			double percent = .2 * (1-schm.getFortune());
			if(percent > 0 && !bs.bp.stm.checkStatus(schm, new incapacitate(schm,schm))){
				schm.setBonusInit(schm.getBonusInit() - percent);
				schm.setBonusEva(schm.getBonusEva() - percent);
			}
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		switch(bs.gs.getVar(24)){
		
		}
		if(bs.gs.getSwitch(34)){
			bs.bp.bt.addScene("Being underwater makes breathing difficult!", new PoisonAnim(s),this, false);
		}
	}
		
	public void postAnimRun(BattleState bs){
		for(Schmuck s : bs.bp.battlers){
			double percent = .2 * (1-s.getFortune());
			if(percent > 0 && !bs.bp.stm.checkStatus(s, new incapacitate(s,s))){
				s.hpChange(-(int)((s.getMaxHp() * percent)));
			}
		}
	}
	
	public int getFrames(){
		return 0;
	}
	
	public int stackingEffect(){
		return 1;
	}
	
	public Boolean runWhenDead(){
		return true;
	}
	
}
