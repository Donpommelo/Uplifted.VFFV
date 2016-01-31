package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class FaithlessCloakStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public FaithlessCloakStatus(int pr){
		super("Faithless",pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int finaldamage = damage;
		if(bs.bp.getSelectableAllies(vic).contains(perp)){
			finaldamage *= .1;
		}
		return finaldamage;
	}
}
