package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PantherPoiseEffect extends status{
	
	public static String name = "Poised";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public PantherPoiseEffect(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
		this.perp = perp;
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Item")){
			if(!perp.equals(bs.bp.TurnOrderQueue.get(0).user)){
				bs.bp.bt.textList.add(perp.getName()+" snatched the item. And ate it.");
			}
			bs.bp.TurnOrderQueue.get(0).setTarget(perp);
		}
	}

	public int stackingEffect(){
		return 3;
	}
}