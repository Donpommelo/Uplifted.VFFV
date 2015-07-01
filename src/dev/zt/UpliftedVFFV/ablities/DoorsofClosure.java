package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoorsofClosure extends Skills {

	public String name = "Doors of Closure";
	public String descr = "User summons elevator doors\nthat close on enemies, dealing\narea damage.";
	public String descrShort = "Damages all enemies.";
	public int cost = 8;
	public DoorsofClosure(int index) {
		super(index,1);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Doors of Closure!");
		for(Schmuck s : bs.bp.getEnemyTargets(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/(s.buffedStats[3]*5), perp, s);
		}

	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Doors of Closure!");
		bs.bp.bt.textList.add("A Critical blow!");
		for(Schmuck s : bs.bp.getEnemyTargets(perp)){
			bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]*5)*(1.5*perp.getCritMulti())), perp, s);
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
	
	public int getTargetType(){
		return targetType;
	}
}
