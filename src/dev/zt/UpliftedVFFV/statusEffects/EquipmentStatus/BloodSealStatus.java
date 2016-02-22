package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BloodSealStatus extends status{

	public BloodSealStatus(int pr){
		super("Blood Pact Made", pr);
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(bs.bp.roundNum == (int)(9*(1+s.getEquipPow()))){
			bs.bp.bt.addScene(s.getName()+"'s Blood Seal glows with a sinister energy!");
			ArrayList<status> removed = new ArrayList<status>();
			for(status st : s.statuses){
				if(!st.perm){
					removed.add(st);
				}
			}
			for(status st : s.statusesChecked){
				if(!st.perm){
					removed.add(st);
				}
			}
			for(status st : removed){
				bs.bp.stm.removeStatus(s, st);
			}
			s.hpChange(-1000000);
		}
	}
}
