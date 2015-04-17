package dev.zt.UpliftedVFFV.Battle;

import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.party.Schmuck;

public class Action {
	
	public Skills skill;
	public Schmuck user;
	public Schmuck target;
	public Action(Schmuck user,Schmuck target,Skills skill){
		this.skill=skill;
		this.user=user;
		this.target=target;
	}
	
	public void run(){
		skill.run(user,target);
	}

}
