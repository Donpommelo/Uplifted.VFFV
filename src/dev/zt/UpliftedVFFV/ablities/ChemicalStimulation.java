package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ChemicalStimulation extends Skills {

	public static String name = "Chemical Stimulation";
	public static String descr = "User assaults a victim's bloodstream with a dubious cocktail of stimulants.";
	public static String descrShort = "Damages restores Motivation to target.\nDeals reduced damage to allies.";
	public static int cost = 13;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public ChemicalStimulation(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.bpChange(damage, vic);
		if(bs.bp.getSelectableAllies(perp).contains(vic)){
			damage *= 0.2;
		}
		bs.bp.em.hpChange(damage, perp, vic,6);		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.bpChange(damage, vic);
		if(bs.bp.getSelectableAllies(perp).contains(vic)){
			damage *= 0.2;
		}
		bs.bp.em.hpChange(damage, perp, vic,6);
	}

}
