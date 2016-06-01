package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Suckered;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SuckerPunchStatus extends status{
	
	public SuckerPunchStatus(Schmuck v,int pr){
		super("Sucker Punching", v,pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		for(Schmuck e : bs.bp.getSelectableEnemies(s)){
			bs.bp.stm.addStatus(e, new Suckered(s,100,s));
		}
	}
}
