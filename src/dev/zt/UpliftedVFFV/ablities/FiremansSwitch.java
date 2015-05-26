package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FiremansSwitch extends Skills {

	public String name = "Fireman's Switch";
	public String descr = "User releases energy from\noverheated machinery to\ndamage foes.";
	public String descrShort = "Deals Red damage to all\nenemies except target.";
	public int cost = 12;
	public FiremansSwitch(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Fireman's Switch!");	
		for(Schmuck s : bs.bs.enemyTargets){
			if(!s.equals(vic)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3]*.8)),s,0);
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
