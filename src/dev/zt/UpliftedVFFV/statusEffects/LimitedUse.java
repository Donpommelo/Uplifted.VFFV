package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.FlavorNothing;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LimitedUse extends status{
	
	public static String name = "Move Limitation";
	public static Boolean perm = true;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = false;
	public int usesLeft;
	public int origUses;
	public Skills move;
	public LimitedUse(Skills m, int uses, Schmuck perp, Schmuck vic, int pr){
		super(1, name, perm, visible, removedEnd, decay, perp, vic, pr);
		this.move = m;
		this.origUses = uses+1;
		this.usesLeft = (int)(uses + perp.getChargeBonus());
	}
		
	public void preActionUser(Schmuck s, Action a, BattleState bs){
		if(a.skill.getName().equals(move.getName())){
			if(usesLeft <= 0 ){
				bs.bp.TurnOrderQueue.set(0, new Action(s,s,new FlavorNothing(0,s.getName()+"'s "+move.getName()+" has no more Charges left!"),bs));				
			}
		}
	}
	
	public void onActionUser(BattleState bs, Action a){
		if(a.skill.getName().equals(move.getName())){
			if(usesLeft >= 0){
				bs.bp.bt.addScene(a.getUser().getName()+"'s "+move.getName()+" has "+usesLeft+" Charges(s) left.");
				move.descrShort = move.descrShort.replace("Charges : "+(usesLeft+1), "Charges : "+usesLeft);
				usesLeft--;
			}
		}
	}
	
	public void onStatusInflict(Schmuck s, status st, BattleState bs){
		if(st.getName() == "Move Limitation" && st.getMove() == move && st != this){
			s.statuses.remove(st);
			s.statusesChecked.remove(st);
		}
	}
	
	public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){
		move.descrShort = move.descrShort.replace("Charges : "+(usesLeft+1), "Charges : "+origUses);
	}
	
	public Skills getMove(){
		return move;
	}
	
	public Boolean runWhenDead(){
		return true;
	}
	
	public int stackingEffect(){
		return 2;
	}
}
