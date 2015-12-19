package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StatusAbsorb extends status{
	
	public static String name = "Status Absorbent";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public StatusAbsorb(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public StatusAbsorb(int pr){
		super(name, pr);
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
		return s.getName()+" became Absorbent!";
	}

	public String cureText(Schmuck s){
		return s.getName()+" is no longer Absobent!";
	}
}
