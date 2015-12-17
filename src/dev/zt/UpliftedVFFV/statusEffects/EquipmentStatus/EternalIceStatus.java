package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class EternalIceStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int cooldown;
	public EternalIceStatus(Schmuck perp, int pr){
		super("Eternally Icy", false, false, perp, pr);
	}
	
	public void statchanges(Schmuck s){
		int conversion = s.buffedElemPoints[1]/2;
		s.buffedElemPoints[1] -= conversion;
		s.buffedStats[3] +=conversion/2;
	}
	
}
