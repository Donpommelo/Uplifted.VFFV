package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoorsofClosure extends Skills {

	public String name = "Doors of Closure";
	public String descr = "User summons elevator doors\nthat close on enemies, dealing\narea damage.";
	public String descrShort = "Damages all enemies.";
	public int cost = 11;
	public DoorsofClosure(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Doors of Closure!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2),vic);	
		if(bs.bp.bm.enemy.contains(vic)){
			for(Schmuck s : bs.bs.enemyTargets){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*3),s);
			}
		}
		else{
			for(Schmuck s : bs.bs.alliesTargets){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*3),s);
			}
		}

	}
		
	public String getName(){
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	

}
