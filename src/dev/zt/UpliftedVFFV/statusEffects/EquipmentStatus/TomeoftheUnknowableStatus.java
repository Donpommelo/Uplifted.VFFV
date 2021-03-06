package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class TomeoftheUnknowableStatus extends status{
	
	public TomeoftheUnknowableStatus(Schmuck v,int pr){
		super("Unknowable",v, pr);
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.addScene(perp.getName()+"'s Tome of the Unknowable produces inexplicable results!");
		status st = bs.bp.stm.randomBad((int)(3*(1+perp.getEquipPow())), perp,vic);
		bs.bp.stm.addStatus(vic, st);
	}

}
