package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LimitedUse extends status{
	
	public static String name = "Move Limited";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public int usesLeft;
	public Skills move;
	public LimitedUse(Skills m, int uses, Schmuck perp, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, pr);
		this.move = m;
		this.usesLeft = (int)(uses + perp.getChargeBonus());
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
	
	public int stackingEffect(){
		return 2;
	}
}
