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
	public static int element = 0;	//Red
	public static int targetType = 0;	//Any Single Target
	public FiremansSwitch(int index) {
		super(index, element, targetType, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
	
		for(Schmuck s : bs.bp.getSelectableAllies(vic)){
			if(!s.equals(vic)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.8);
				bs.bp.em.hpChange(damage, perp, s,0);
			}		
		}
	}
		
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.getSelectableAllies(vic)){
			if(!s.equals(vic)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s)*(1.5+perp.getCritMulti()-s.getCritRes()) * 0.8);
				bs.bp.em.hpChange(damage, perp, s,0);
			}		
		}
	}	
}
