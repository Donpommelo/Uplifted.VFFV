package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class SalvagerScrapRipperStatus extends status{

	public SalvagerScrapRipperStatus(Schmuck v,int pr){
		super("Scrappy Salvager", v,pr);
	}
	
	public void statchanges(Schmuck s, BattleState bs){
		s.setCritChance(s.getCritChance()+.20*(1+s.getEquipPow()));
	}
	
	public void onCrit(Schmuck perp,Schmuck vic, Action a, BattleState bs){
		bs.bp.bt.addScene(perp.getName()+"'s Scrap-Ripper salvages for items!");
		bs.bp.stm.addStatus(perp, new BonusStatBuff(5,4,.1,perp,perp,40));
	}
}
