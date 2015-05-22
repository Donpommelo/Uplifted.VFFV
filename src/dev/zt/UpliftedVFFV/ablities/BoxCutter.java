package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class BoxCutter extends Skills {

	public String name = "Box Cutter";
	public String descr = "A quick and reliable stab with a\nbox-opening blade. This attack\nwill deal consistent damage\nscaling to its user's Level.";
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
	
	public String getDescr() {
		return descr;
	}
	
	public int getCost(){
		return cost;
	}
	

}
