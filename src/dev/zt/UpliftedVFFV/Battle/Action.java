package dev.zt.UpliftedVFFV.Battle;

import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Action {
	
	//An Action is the basic act of a Schmuck doing something to another Schmuck in battle.
	
	//skill: the thing the Schmuck is doing.
	public Skills skill;
	
	//user: the Schmuck doing the doing.
	public Schmuck user;
	
	//target: the Schmuck that doing is being done to.	
	public Schmuck target;
	
	//bs: the Battle State where all this is happening.
	public BattleState bs;
	
	public Action(Schmuck user,Schmuck target,Skills skill, BattleState bs){
		this.skill=skill;
		this.user=user;
		this.target=target;
		this.bs=bs;
	}
	
	//Actions are run in the Battle Processor when it is the user's turn.
	//Running an action simply consists of running the skill with the user and target as inputs.
	public void run(){
		skill.run(user,target,bs);
	}

	//Getters and Setters for Action variables.
	
	
	public Skills getSkill() {
		return skill;
	}

	public void setSkill(Skills skill) {
		this.skill = skill;
	}
	
	public Schmuck getUser() {
		return user;
	}

	public void setUser(Schmuck user) {
		this.user = user;
	}

	public Schmuck getTarget() {
		return target;
	}

	public void setTarget(Schmuck target) {
		this.target = target;
	}	

}
