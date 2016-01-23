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
	}
	
	public BindStatus(int pr){
		super(name, pr);
	}
	
	public void preBattlePhase(Schmuck s, BattleState bs){
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i) != null){
				System.out.println(bs.bp.TurnOrderQueue.get(i).getUser().getName());
				if(bs.bp.TurnOrderQueue.get(i).getUser().equals(s)){
					System.out.print("meep");
					bs.bp.TurnOrderQueue.set(i, new Action(s,s,new FlavorNothing(0,s.getName()+" is Binding "+victim.getName()+" in place!"),bs));
				}
				else if(bs.bp.TurnOrderQueue.get(i).getUser().equals(victim)){
					System.out.print("mierp");
					bs.bp.TurnOrderQueue.set(i, new Action(victim,victim,new FlavorNothing(0,victim.getName()+" is being Binded by "+s.getName()+"!"),bs));
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
