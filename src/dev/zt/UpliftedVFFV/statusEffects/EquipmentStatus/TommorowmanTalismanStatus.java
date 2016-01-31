package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class TommorowmanTalismanStatus extends status{
	
	ArrayList<status> delayed;
	public TommorowmanTalismanStatus(int pr){
		super("Tommorowing", pr);
		this.delayed = new ArrayList<status>();
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+" receives delayed statuses!");
		for(status st : delayed){
			bs.bp.stm.addStatus(s, st);
		}

	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Tommorowman Talisman decides that the status can wait!");
		delayed.add(st);
		bs.bp.stm.removeStatus(s, st);
	}
}
