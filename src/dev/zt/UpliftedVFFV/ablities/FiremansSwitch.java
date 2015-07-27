package dev.zt.UpliftedVFFV.ablities;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FiremansSwitch extends Skills {

	public static String name = "Fireman's Switch";
	public static String descr = "User releases energy from\noverheated machinery to\ndamage foes.";
	public static String descrShort = "Deals Red damage to all\nenemies except target.";
	public static int cost = 12;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public FiremansSwitch(int index) {
		super(index,0,0, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Fireman's Switch!");	
		
		for(Schmuck s : bs.bp.getSelectableAllies(vic)){
			if(!s.equals(vic)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(s.buffedStats[3]*.8)), perp,s,0);
			}		
		}
	}
		
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Fireman's Switch!");	
		bs.bp.bt.textList.add("A Critical blow!");
		for(Schmuck s : bs.bp.getSelectableAllies(vic)){
			if(!s.equals(vic)){
				bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3]*.8)*(1.5+perp.getCritMulti())), perp, vic,0);
			}		
		}
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			if(!s.equals(vic)){
				damage += bs.bp.em.damageSimulation((int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.8)/(s.buffedStats[3])),perp,s,0,1000);
			}	
		}
		return damage;
	}
	
}
