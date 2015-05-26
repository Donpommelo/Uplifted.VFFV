package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.InvertedSwanBonusAttack;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class InvertedSwanEffect extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
//	public BattleState bs;
	public InvertedSwanEffect(int i){
		super(i, "Inverted Swan", true);
//		this.bs = bs;
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.textList.add(perp.getName()+"'s Inverted Swan grants a double-attack.");
		bs.bp.TurnOrderQueue.add(1, new Action(perp, vic, new InvertedSwanBonusAttack(0),bs));
	}

	public String inflictText(Schmuck s){
		return s.getName()+" looks light on his/her feet.";

	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Inverted Swan wore off.";
	}
	
	public int getDuration(){
		return duration;
	}

}
