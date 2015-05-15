package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class BoxCutter extends Skills {

	public String name = "Box Cutter";
	public int cost = 1;
	public BoxCutter(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Box Cutter!");
		bs.bp.em.hpChange(-(perp.Lvl*2+5),vic);
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}
	

}
