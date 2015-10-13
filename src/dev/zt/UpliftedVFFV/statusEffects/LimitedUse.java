package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LimitedUse extends status{
	
	public int duration;
	public Boolean perm = true;
	public Boolean visible = false;
	public int usesLeft;
	public Skills move;
	public LimitedUse(int i,Skills m, int uses, Schmuck perp, int pr){
		super(999,"MoveLimit",true, false, true, perp, pr);
		this.move = m;
		this.usesLeft = (int)(uses + perp.getChargeBonus());
	}
	
	public LimitedUse(Schmuck perp, int pr){
		super("Limited Use Move", false, true, perp, pr);
	}
	
	public void restrict(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals(move.getName())){
			if(usesLeft>0){
				usesLeft--;
				bs.bp.bt.textList.add(s.getName()+"'s  "+move.getName()+" has "+usesLeft+" uses left.");
			}
			else{
				bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+"'s "+move.getName()+" has no more uses left!"),bs));				
			}
		}
	}
}
