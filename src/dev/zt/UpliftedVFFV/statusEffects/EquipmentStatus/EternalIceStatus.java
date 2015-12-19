package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class EternalIceStatus extends status{

	public EternalIceStatus(int pr){
		super("Eternally Icy", pr);
	}
	
	public void statchanges(Schmuck s){
		int conversion = s.buffedElemPoints[1]/2;
		s.buffedElemPoints[1] -= conversion;
		s.buffedStats[3] +=conversion/2;
	}
	
}
