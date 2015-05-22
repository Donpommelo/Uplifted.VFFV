package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.IntrusiveThoughtEffect;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class IntrusiveThought extends Skills {

	public String name = "Intrusive Thought";
	public String descr = "User causes a target's Intrusive\nThoughts to flourish,\nstacking an invisible debuff.";
	public int cost;
	public IntrusiveThought(int index) {
		super(index);
		cost = 1;

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Intrusive Thought!");
		bs.bp.em.hpChange(-(1),vic);
		int stacked = -1;
		for(status s : vic.statuses){
			if(s!=null){
				if(s.getName().equals("Intrusive Thoughts")){
					stacked = vic.statuses.indexOf(s);
				}	
			}
							
		}
		if(stacked!=-1){
			vic.statuses.get(stacked).stack++;
			bs.bp.bt.textList.add(vic.getName()+"'s Intrusive Thoughts grow.");
		}
		else{
			bs.bp.stm.addStatus(vic, new IntrusiveThoughtEffect(10, bs));
		}

		
	}
	
	public String getName(){
		return name;
	}
	
	public String geDescr(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}
	

}
