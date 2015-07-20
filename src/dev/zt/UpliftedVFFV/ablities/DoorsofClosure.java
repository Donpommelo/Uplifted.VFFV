package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoorsofClosure extends Skills {

	public static String name = "Doors of Closure";
	public static String descr = "User summons elevator doors\nthat close on enemies, dealing\narea damage.";
	public static String descrShort = "Damages all enemies.";
	public static int cost = 8;
	public DoorsofClosure(int index) {
		super(index,1,6, name, descr, descrShort, cost);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Doors of Closure!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/(s.buffedStats[3]*5), perp, s,6);
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Doors of Closure!");
		bs.bp.bt.textList.add("A Critical blow!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]*5)*(1.5+perp.getCritMulti())), perp, s,6);
		}		
	}
		
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/(s.buffedStats[3]*5),perp,s,6,1000);
		}
		return damage;
	}
	
	
}
