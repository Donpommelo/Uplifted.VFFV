package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EchoShellStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;

	public EchoShellStatus(Schmuck perp, int pr){
		super("Echoing", false, false, perp, pr);
	}
		
	public void endofturnEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Echo Shell echoes effects!");
		for(int i=0; i<s.statuses.size(); i++){
			if(s.statuses.get(i)!=null && s.statuses.get(i).getName() != "Echoing"){
				s.statuses.get(i).endofturnEffect(s, bs);	
			}
		}
	}
}
