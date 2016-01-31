package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EnergyExhaust extends status{
	
	public double energy;
	public EnergyExhaust(int pr){
		super("Exhaustible", pr);
		energy = 0;
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		bs.bp.bt.addScene(s.getName()+"'s Energy Source crackles with power!");
		energy = .25;
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(energy > -.10){
			bs.bp.bt.addScene(s.getName()+"'s Energy Source seems a little dimmer!");
			energy -= .05;
		}
		if(energy == 0){
			bs.bp.bt.addScene(s.getName()+"'s Energy Source seems thoroughly exhausted!");
		}
	}
	
	public void statchanges(Schmuck s){
		s.bonusStats[35] += (energy * s.getMaxBp() * (1 + s.getEquipPow()));
	}
}
