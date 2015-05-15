package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class ForeseeIll extends Skills {

	public String name = "Ennervate";
	public int cost = 4;
	public ForeseeIll(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" Foresees Ill!");
		int stacked = -1;
		for(status s : vic.statuses){
			if(s.getName().equals("Intrusive Thoughts")){
				stacked = vic.statuses.indexOf(s);
			}					
		}
		if(stacked != -1){
			bs.bp.em.hpChange(-(int)Math.pow(2, vic.statuses.get(stacked).stack),vic);
			bs.bp.stm.removeStatus(vic, vic.statuses.get(stacked));
		}
		else{
			bs.bp.bt.textList.add("But it failed.");
		}
		
	}

	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}


}
