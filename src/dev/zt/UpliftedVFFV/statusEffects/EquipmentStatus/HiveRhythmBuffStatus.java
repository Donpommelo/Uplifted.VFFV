package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class HiveRhythmBuffStatus extends status{

	public HiveRhythmBuffStatus(Schmuck v,int pr){
		super("One with the Hive",v, pr);
		this.setExtraVar1(6);
	}
	
	public void statchanges(Schmuck s){
		switch(this.getExtraVar1()){
		case 0:
			s.setRedPoints(s.getRedPoints()+10);
			break;
		case 1:
			s.setBluePoints(s.getBluePoints()+10);
			break;
		case 2:
			s.setGreenPoints(s.getGreenPoints()+10);
			break;
		case 3:
			s.setYellowPoints(s.getYellowPoints()+10);
			break;
		case 4:
			s.setPurplePoints(s.getPurplePoints()+10);
			break;
		}
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		this.setExtraVar1(6);
	}
	
	public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){
		this.setExtraVar1(6);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		this.setExtraVar1(6);
	}
	
}
