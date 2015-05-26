package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.DisarmedNothing;
import dev.zt.UpliftedVFFV.ablities.InvertedSwanBonusAttack;
import dev.zt.UpliftedVFFV.ablities.SilencedNothing;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class PantherPoiseEffect extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = false;
	public Schmuck user;
	public PantherPoiseEffect(int i, Schmuck user){
		super(i, "PantherPoiseEffect", true);
		this.user = user;
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals("Item")){
			if(!user.equals(bs.bp.TurnOrderQueue.get(0).user)){
				bs.bp.bt.textList.add(user.getName()+" snatched the item. And ate it.");
			}
			bs.bp.TurnOrderQueue.get(0).setTarget(user);
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
