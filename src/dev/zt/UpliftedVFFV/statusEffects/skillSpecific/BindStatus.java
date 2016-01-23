package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.DreamEaterStatus;

public class BindStatus extends status{
	
	public static String name = "Binding Target";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public Schmuck victim;
	public Schmuck perp;
	public BindStatus(int i, Schmuck perp, Schmuck target, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.victim = target;
		this.perp = perp;
	}
	
	public BindStatus(int pr){
		super(name, pr);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i) != null){
				if(bs.bp.TurnOrderQueue.get(i).getUser().equals(perp)){
					bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,perp.getName()+" is holding "+victim.getName()+" in place!"),bs));
				}
				if(bs.bp.TurnOrderQueue.get(i).getUser().equals(victim)){
					bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,victim.getName()+" is being Binded by "+perp.getName()+"!"),bs));
				}
			}
		}
	}

	public String inflictText(Schmuck s){
		return victim.getName()+" was Binded!";
	}

	public String cureText(Schmuck s){
		return victim.getName()+" was freed!";
	}

}
