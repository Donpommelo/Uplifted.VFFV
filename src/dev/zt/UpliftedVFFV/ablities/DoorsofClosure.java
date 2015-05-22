package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoorsofClosure extends Skills {

	public String name = "Doors of Closure";
	public String descr = "User summons elevator doors\nthat close on enemies, dealing\narea damage.";
	public int cost = 8;
	public DoorsofClosure(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Doors of Closure!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),vic);	
		if(bs.bp.bm.enemy.contains(vic)){
			for(Schmuck s : bs.bp.bm.enemy){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),s);
			}
		}
		else{
			for(Schmuck s : bs.bp.bm.allies){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),s);
			}
		}

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
