package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class SlackerSlacksStatus extends status{
	
	public static String name = "Slacking";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	
	public SlackerSlacksStatus(int pr){
		super(name, pr);
	}
	
	public void onDillyDally(Schmuck s, BattleState bs){
		bs.bp.bt.addScene(s.getName()+"'s Slacker Slacks make waiting more comfortable!");
		bs.bp.em.hpChange((int)(s.getMaxHp()*.1*(1+s.getEquipPow())), s, s, 6);
	}
	
}
