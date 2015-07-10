package dev.zt.UpliftedVFFV.statusEffects;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MadnessMantraStatus extends status{
	
	public int duration;
	public Boolean perm = false;
	public Boolean visible = true;
	public int stack;
	public Skills lastUsed;

	public MadnessMantraStatus(Schmuck perp, int pr){
		super("Maddening", false, false, perp, pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		stack = 0;
	}
	
	public void onAction(BattleState bs, Action a){
		if(a.skill.getName().equals(lastUsed.getName())){
			if(stack < 5){
				bs.bp.bt.textList.add(a.user.getName()+"'s Madness Mantra glows ominously.");
				stack++;
			}
		}
		else{
			bs.bp.bt.textList.add(a.user.getName()+"'s Madness Mantra stopped glowing.");
			lastUsed = a.skill;
			stack = 0;
		}
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[2] += 5*stack;
		s.buffedStats[4] += 5*stack;

	}
	
	
	
	public String inflictText(Schmuck s){
		return "";

	}

	public String cureText(Schmuck s){
		return "";
	}
	
}
