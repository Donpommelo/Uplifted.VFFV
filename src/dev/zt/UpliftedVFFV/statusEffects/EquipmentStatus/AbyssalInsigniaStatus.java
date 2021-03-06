package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AbyssalInsigniaStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public AbyssalInsigniaStatus(Schmuck v,int pr){
		super("Abyssal Alignment",v, pr);
	}
	
	public void statchanges(Schmuck s){
		if(s.getPrismaticPoints() < 0){
			s.buffedElemPoints[5] -= s.getPrismaticPoints()*(1+s.getEquipPow());
		}
	}
}
