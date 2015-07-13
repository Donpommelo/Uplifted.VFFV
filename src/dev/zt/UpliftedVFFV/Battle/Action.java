package dev.zt.UpliftedVFFV.Battle;

import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Action {
	
	public Skills skill;
	public Schmuck user;
	public Schmuck target;
	public BattleState bs;
	public Action(Schmuck user,Schmuck target,Skills skill, BattleState bs){
		this.skill=skill;
		this.user=user;
		this.target=target;
		this.bs=bs;
	}
	
	public void run(){
		skill.run(user,target,bs);
	}

	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}

	public Schmuck getTarget() {
		return target;
	}

	public void setTarget(Schmuck target) {
		this.target = target;
	}
	
	

}
