package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class MotorGrinder extends Skills {

	public String name = "Motorgrinder";
	public int cost = 10;
	public MotorGrinder(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-(perp.BuffedPow*perp.BuffedPow)/vic.BuffedDef,vic);

	}
	
	public String useText(Schmuck perp, Schmuck vic){
		return perp.getName()+" summons crushing gears!";
	}
	
	public String resultText(Schmuck perp, Schmuck vic){
//		return vic.getName()+" receives "+(perp.BuffedPow*perp.BuffedPow)/vic.BuffedDef+" damage.";
		return "";
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}

}
