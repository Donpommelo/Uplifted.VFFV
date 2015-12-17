package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SimpleMindStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public SimpleMindStatus(int i, Schmuck perp, int pr){
		super(i, "Simple", false, true, true, perp, pr);
	}
	
	public SimpleMindStatus(Schmuck perp, int pr){
		super("Simple", true, false, perp, pr);
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		for(status meep : s.statuses){
			if(!meep.perm && !meep.getName().equals("incapacitated")) {
				bs.bp.stm.removeStatus(s, meep);
			}
		}
		bs.bp.stm.addStatus(s, st);
	}
	
	
	public String inflictText(Schmuck s){
		return s.getName()+"";
	}

	public String cureText(Schmuck s){
		return s.getName()+"";
	}
}
