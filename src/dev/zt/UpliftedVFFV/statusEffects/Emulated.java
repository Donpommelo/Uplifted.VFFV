package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Emulated extends status{
	
	public static String name = "Emulated";
	public static Boolean perm = false;
	public static Boolean visible = true;
	public static Boolean removedEnd = false;
	public static Boolean decay = true;
	public Emulated(int i, Schmuck perp, Schmuck vic, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, vic, pr);
	}
	
	public Emulated(Schmuck v,int pr){
		super(name, v,pr);
	}

	public void onActionUser(BattleState bs, Action a){
		if(a.getSkill().getTargetType() == 0 && a.getSkill().startTarget() == false && a.getTarget() == perp){
			bs.bp.bt.addScene(perp.getName()+" Emulated the ability!");
			bs.bp.TurnOrderQueue.add(1,new Action(a.getTarget(),a.getUser(),a.getSkill(),bs));
		}
	}
		
	public Boolean isBad(){
		return true;
	}
}
