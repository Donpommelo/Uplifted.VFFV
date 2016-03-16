package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MaskofFestusStatus extends status{
	
	public MaskofFestusStatus(int pr){
		super("Silencing Strikes", pr);
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		if(Math.random()<.5*(1+perp.getEquipPow())*(float)(perp.getBuffedLuk()/vic.getBuffedLuk())){
			bs.bp.bt.addScene(". . .");
			bs.bp.stm.addStatus(vic, new Silenced(1, perp, vic, 50));
		}
	}
	
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.silenceBlocked()){
			bs.bp.bt.addScene(s.getName()+" tried to use . . . something . . .");
			bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,". . ."),bs));
		}
	}
}
