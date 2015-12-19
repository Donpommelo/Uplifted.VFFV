package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class AbsoluteThresholdStatus extends status{
	
	public double percent;
	public static String name = "Damage Ignoring";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public AbsoluteThresholdStatus(int i, double percent, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.percent = percent;
	}
	
	public AbsoluteThresholdStatus(double percent, int pr){
		super(name, pr);
		this.percent = percent;
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		if(-damage <= percent * vic.getMaxHp()){
			bs.bp.bt.textList.add(vic.getName()+"'s Absolute Threshold blocks damage!");
			return 0;
		}
		else{
			return damage;
		}
	}	
}
