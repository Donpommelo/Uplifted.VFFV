package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoorsofClosure extends Skills {

	public String name = "Doors of Closure";
	public int cost = 8;
	public DoorsofClosure(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange(-(perp.BuffedPow*perp.BuffedPow)/(vic.BuffedDef*2),vic);
		if(bs.bp.bm.enemy.contains(vic)){
			for(Schmuck s : bs.bp.bm.enemy){
				bs.bp.em.hpChange(-(perp.BuffedPow*perp.BuffedPow)/(vic.BuffedDef*2),s);
			}
		}
		else{
			for(Schmuck s : bs.bp.bm.allies){
				bs.bp.em.hpChange(-(perp.BuffedPow*perp.BuffedPow)/(vic.BuffedDef*2),s);
			}
		}

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" closes doors on enemies!";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
//		return "All targets are damaged.";
		return "";
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}

}
