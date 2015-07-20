package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.party.Schmuck;

public class PrismShield extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public PrismShield(Schmuck perp, int pr){
		super("Prism Shield", false, false, perp, pr);
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
