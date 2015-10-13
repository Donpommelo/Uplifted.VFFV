package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class HoGStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public HoGStatus(Schmuck perp, int pr){
		super("Glorious", false, false, perp, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		setCooldown(0);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		if(getCooldown() == 0){
			bs.bp.bt.textList.add(s.getName()+"'s Hand of Glory Activates!");
			Schmuck target = bs.bp.getSelectableEnemies(s).get((int)(Math.random()*bs.bp.getSelectableEnemies(s).size()));
			bs.bp.stm.addStatus(target, new Stunned(2,perp, 50));				
			setCooldown((int)(7 - s.getCooldownBonus()));
		}
	}
	
	public void endofturnEffect(Schmuck s, BattleState bs){
		if(getCooldown() >0){
			setCooldown(getCooldown()-1);
		}
	}	
}
