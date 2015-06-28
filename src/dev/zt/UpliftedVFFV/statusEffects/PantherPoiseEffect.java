package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PantherPoiseEffect extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public PantherPoiseEffect(int i, Schmuck perp){
		super(i, "PantherPoiseEffect", false, false, true, perp);
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

	public String inflictText(Schmuck s){
		return "";

	}

	public String cureText(Schmuck s){
		return "";
	}
	
	public int getDuration(){
		return duration;
	}

}
