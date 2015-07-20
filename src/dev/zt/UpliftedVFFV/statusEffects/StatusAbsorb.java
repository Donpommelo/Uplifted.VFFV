package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StatusAbsorb extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public StatusAbsorb(int i, Schmuck perp, int pr){
		super(i, "Status Absorb", false, true, true, perp, pr);
	}
	
	public StatusAbsorb(Schmuck perp, int pr){
		super("Status Absorb", true, false, perp, pr);
	}
	
	public void onKill(Schmuck perp, Schmuck vic, BattleState bs){
		if(!perp.equals(vic)){
			bs.bp.bt.textList.add(perp.getName()+" copied "+vic.getName()+"'s statuses!");
			for(status s : vic.statuses){
				if(!s.perm && !s.getName().equals("incapacitated")) {
					bs.bp.stm.addStatus(perp, s);
				}
			}
		}
	}
	
	public String inflictText(Schmuck s){
		return s.getName()+"";
	}

	public String cureText(Schmuck s){
		return s.getName()+"";
	}
}
