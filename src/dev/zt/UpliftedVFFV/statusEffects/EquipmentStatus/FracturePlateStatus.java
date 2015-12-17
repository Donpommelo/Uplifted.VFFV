package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TempFortify;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FracturePlateStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public FracturePlateStatus(Schmuck perp, int pr){
		super("Fracturing", false, false, perp, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){//
		bs.bp.stm.addStatus(s, new TempFortify(100,7,s,50));
	}
	
	public void endoffightEffect(Schmuck s, BattleState bs){
		bs.bp.stm.removeStatus(s, new TempFortify(100,7,s,50));
	}
}
