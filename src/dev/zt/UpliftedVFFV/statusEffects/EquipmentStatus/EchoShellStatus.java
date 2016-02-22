package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EchoShellStatus extends status{
	
	public EchoShellStatus(int pr){
		super("Echoing", pr);
	}
		
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Echo Shell echoes effects!");
		
		for(status st : s.statusesChecked){
			s.statuses.add(st);
		}
		s.statusesChecked.clear();
		
		while(!s.statuses.isEmpty()){
			status tempStatus = s.statuses.get(0);
			
			if(tempStatus!=null && tempStatus.getName() != "Echoing"){
				tempStatus.endofturnEffect(s, bs);	
			}
			
			if(s.statuses.contains(tempStatus)){
				s.statuses.remove(tempStatus);
				s.statusesChecked.add(tempStatus);
			}
		}
		s.calcBuffs(bs);
	}
}
