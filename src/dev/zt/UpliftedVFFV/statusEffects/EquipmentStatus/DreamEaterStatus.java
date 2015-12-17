package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class DreamEaterStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public DreamEaterStatus(Schmuck perp, int pr){
		super("Dream Eater", false, false, perp, pr);
	}
	
	
}
