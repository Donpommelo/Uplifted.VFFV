package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TempFortify;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FracturePlateStatus extends status{

	public FracturePlateStatus(int pr){
		super("Fracturing", pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		bs.bp.bt.textList.add(s.getName()+"'s Fracture Plate fused together!");
		bs.bp.stm.addStatus(s, new TempFortify(7,s,50));
	}	
}
