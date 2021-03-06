package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class HoGStatus extends status{
	
	public HoGStatus(Schmuck v,int pr){
		super("Glorious", v, pr);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		if(!bs.bp.stm.checkStatus(s, new CoolingDown(0,s,s,50))){
			bs.bp.bt.addScene(s.getName()+"'s Hand of Glory Activates!");
			Schmuck target = bs.bp.getSelectableEnemies(s).get((int)(Math.random()*bs.bp.getSelectableEnemies(s).size()));
			bs.bp.stm.addStatus(target, new Stunned((int)(2 * (1 + s.getEquipPow())),perp,target, 50));				
			bs.bp.stm.addStatus(s, new CoolingDown(5, s, s,50));
		}
	}

}
