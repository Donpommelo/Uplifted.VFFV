package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.OutofUsesNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LimitedUse extends status{
	
	public int duration;
	public Boolean perm = true;
	public Boolean visible = false;
	public int usesLeft;
	public Skills move;
	public LimitedUse(int i,Skills m, int uses, Schmuck perp){
		super(999,"MoveLimit",true, false, true, perp);
		this.move = m;
		this.usesLeft = uses;
	}
	
	public LimitedUse(Schmuck perp){
		super("Limited Use Move", false, true, perp);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals(move.getName())){
			if(usesLeft>0){
				usesLeft--;
				bs.bp.bt.textList.add(s.getName()+"'s  "+move.getName()+" has "+usesLeft+" uses left.");
			}
			else{
				bs.bp.TurnOrderQueue.set(0, new Action(s,s,new OutofUsesNothing(0,a.skill),bs));				
			}
		}
	}
	
	public void onAction(BattleState bs, Action a){
		if(a.skill.getName().equals(move.getName())){
			bs.bp.bt.textList.add(a.user.getName()+"'s  "+move.getName()+" has "+usesLeft+" uses left.");
		}
	}

	public String inflictText(Schmuck s){
		return "";

	}

	public String cureText(Schmuck s){
		return "meep";
	}
	
}
