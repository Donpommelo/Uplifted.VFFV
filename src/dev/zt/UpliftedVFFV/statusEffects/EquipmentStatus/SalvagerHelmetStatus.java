package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SalvagerHelmetStatus extends status{

	public SalvagerHelmetStatus(Schmuck v,int pr){
		super("Helmeted Salvager", v,pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		s.setFortune(s.getFortune()+0.3*(1+s.getEquipPow()));
		if(bs.gs.getSwitch(34)){
			s.setBonusItem(s.getBonusItem()+0.2*(1+s.getEquipPow()));
		}
		else{
			s.setBonusItem(s.getBonusItem()+0.1*(1+s.getEquipPow()));
		}
		
		//Set Bonus
		if(bs.bp.stm.checkStatus(s, new SalvagerScrapRipperStatus(s,50)) && bs.bp.stm.checkStatus(s, new SalvagerToolBeltStatus(s,50))){
			if(bs.gs.getSwitch(34)){
				s.setBonusItem(s.getBonusItem()+0.2*(1+s.getEquipPow()));
			}
			else{
				s.setBonusItem(s.getBonusItem()+0.1*(1+s.getEquipPow()));
			}
		}
	}
}
