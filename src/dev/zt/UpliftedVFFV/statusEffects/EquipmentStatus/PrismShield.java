package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PrismShield extends status{
	
	public PrismShield(Schmuck v,int pr){
		super("Prism Shield", v, pr);
	}
	
	public void statchanges(Schmuck s){
		double most = 0;
		for(int i = 19; i<24; i++){
			if(s.getBonusStats()[i]>most){
				most = s.getBonusStats()[i];
			}
		}
		s.setRedRes(most);
		s.setBlueRes(most);
		s.setGreenRes(most);
		s.setYellowRes(most);
		s.setPurpleRes(most);
	}
}
