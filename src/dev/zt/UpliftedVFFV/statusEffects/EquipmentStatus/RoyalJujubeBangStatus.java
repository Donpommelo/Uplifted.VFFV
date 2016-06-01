package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RoyalJujubeBangStatus extends status{
	
	double exchange;
	boolean powtoinit;
	public RoyalJujubeBangStatus(Schmuck v,int pr){
		super("Royally Jujube", v,pr);
		this.powtoinit = true;
		this.exchange = 0;
	}
	
	public void statchanges(Schmuck s){
		if(powtoinit){
			s.setBuffedPow((int)(s.getBuffedPow() * (1 + (1.25)*exchange)));
			s.setBonusInit(s.getBonusInit() - exchange);
		}
		else{
			s.setBuffedPow((int)(s.getBuffedPow() * (1 - exchange)));
			s.setBonusInit(s.getBonusInit() + (1.25)*exchange);
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(Math.random() > 0.5){
			powtoinit = true;
		}
		else{
			powtoinit = false;
		}
		exchange = Math.random();
	}
}
