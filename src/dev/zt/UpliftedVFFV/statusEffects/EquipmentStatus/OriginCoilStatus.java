package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.CoolingDown;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class OriginCoilStatus extends status{
	
	public static String name = "Lifespring";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	
	public OriginCoilStatus(int pr){
		super(name, pr);
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		if(!bs.bp.stm.checkStatus(s, new CoolingDown(0,s,50))){
			bs.bp.bt.addScene(s.getName()+"'s Origin Coil activates!");
			for(Schmuck ally : bs.bp.getSelectableAllies(s)){
				bs.bp.em.hpChange((int)(80*(1+s.getEquipPow())), s, ally, 6);
			}	
			bs.bp.stm.addStatus(s, new CoolingDown(5, s, 50));
		}
	}
	
}
