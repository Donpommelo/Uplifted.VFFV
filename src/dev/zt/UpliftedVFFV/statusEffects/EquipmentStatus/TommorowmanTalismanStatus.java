package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class TommorowmanTalismanStatus extends status{
	
	ArrayList<status> delayed;
	public TommorowmanTalismanStatus(Schmuck v,int pr){
		super("Tommorowing",v, pr);
		this.delayed = new ArrayList<status>();
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		if(!delayed.isEmpty()){
			bs.bp.bt.addScene(s.getName()+" receives delayed statuses!");
			for(status st : delayed){
				bs.bp.stm.addStatus(s, st);
			}
			delayed.clear();
		}
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(!st.perm && st.visible && bs.bp.stm.checkStatus(s, st) && !delayed.contains(st)){
			bs.bp.bt.addScene(s.getName()+"'s Tommorowman Talisman decides that the status can wait!");
			delayed.add(st);
			s.statuses.remove(st);
		}
	}
}
