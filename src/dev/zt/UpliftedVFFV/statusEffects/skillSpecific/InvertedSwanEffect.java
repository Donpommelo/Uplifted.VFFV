package dev.zt.UpliftedVFFV.statusEffects.skillSpecific;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.InvertedSwanBonusAttack;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class InvertedSwanEffect extends status{
	
	public static String name = "Inverted Swan";
	public static Boolean perm = false;
	public static Boolean visible = false;
	public static Boolean removedEnd = true;
	public static Boolean decay = true;
	public InvertedSwanEffect(int i, Schmuck perp, int pr){
		super(i, name, perm, visible, removedEnd, decay, perp, pr);
	}
	
	public void attackModify(Schmuck perp,Schmuck vic, BattleState bs, int damage){
		bs.bp.bt.addScene(perp.getName()+"'s Inverted Swan grants a double-attack.");
		bs.bp.TurnOrderQueue.add(1, new Action(perp, vic, new InvertedSwanBonusAttack(0),bs));
	}

	public String inflictText(Schmuck s){
		return s.getName()+" looks light on his/her feet.";
	}

	public String cureText(Schmuck s){
		return s.getName()+"'s Inverted Swan wore off.";
	}
	
	public int stackingEffect(){
		return 3;
	}
}
