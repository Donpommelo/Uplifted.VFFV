package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BandagedSwordStatus extends status{
		
	public BandagedSwordStatus(Schmuck v,int pr){
		super("Bandanged Sword Status",v, pr);
	}	
		
	public String inflictText(Schmuck s){
		return "kodakodakodakodak";
	}

	public String cureText(Schmuck s){
		return "kodakodakodakodak";
	}
}
