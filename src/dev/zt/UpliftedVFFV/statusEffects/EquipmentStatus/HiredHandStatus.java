package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class HiredHandStatus extends status{
	
	public HiredHandStatus(int pr){
		super("Hiring Hands", pr);
	}

	public void preBattlePhase(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Hired Hand attacks!");
		Schmuck target = bs.bp.getSelectableEnemies(s).get((int)(Math.random()*bs.bp.getSelectableEnemies(s).size()));
		bs.bp.em.hpChange(-s.getLvl()*2-8, target, s, 6);
	}

	public int onLootScript(Schmuck s, BattleState bs, int script){
		bs.bp.bt.addScene(s.getName()+"'s Hired Hand takes its cut!");
		int finalscript = script;
		finalscript -= 10;
		if(finalscript < 0){
			finalscript = 0;
		}
		return finalscript;
	}
	
}
