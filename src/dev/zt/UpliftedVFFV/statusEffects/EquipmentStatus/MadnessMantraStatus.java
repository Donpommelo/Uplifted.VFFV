package dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class MadnessMantraStatus extends status{

	public int stack;
	public Skills lastUsed;
	public MadnessMantraStatus(Schmuck v,int pr){
		super("Maddening", v,pr);
	}
	
	public void startoffightEffect(Schmuck s, BattleState bs){
		stack = 0;
	}
	
	public void endoffightEffect(Schmuck s, Boolean won, BattleState bs){
		stack = 0;
	}
	
	public void onActionUser(BattleState bs, Action a){
		if(lastUsed != null){
			if(a.skill.getName().equals(lastUsed.getName())){
				if(stack < 5){
					bs.bp.bt.addScene(a.user.getName()+"'s Madness Mantra glows ominously.");
					stack++;
				}
			}
			else{
				bs.bp.bt.addScene(a.user.getName()+"'s Madness Mantra stopped glowing.");
				lastUsed = a.skill;
				stack = 0;
			}
		}
		else{
			if(a.skill.getName() != "Attack" && a.skill.getName() != "Item" && a.skill.getName() != "Dilly Dally"){
				lastUsed = a.skill;
			}
		}
	}
	
	public void statchanges(Schmuck s){
		s.buffedStats[2] += 5*stack*(1+s.getEquipPow());
		s.bonusStats[5] += .2*stack*(1+s.getEquipPow());
		s.bonusStats[13] -= .2*stack;
	}
}
