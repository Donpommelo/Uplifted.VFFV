package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CatoNeedStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public CatoNeedStatus(Schmuck v,int pr){
		super("Needs Met",v,pr);
	}
	
	public int takedamageEffect(Schmuck perp,Schmuck vic, BattleState bs, int damage, int elem){
		int overkill = vic.getCurrentHp() + damage;
		if(overkill <= 0){
			if(vic.getCurrentBp() >= -(overkill*2+5)){
				bs.bp.bt.addScene(vic.getName()+"'s Catalogue of Need maintains vital processes!");
				bs.bp.em.bpChange((overkill*2-5), vic);
				return -vic.getCurrentHp()+1;
			}
			else{
				return damage;
			}
		}
		else{
			return damage;
		}
	}
}
