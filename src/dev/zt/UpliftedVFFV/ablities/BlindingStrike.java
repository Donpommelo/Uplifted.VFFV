package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;

public class BlindingStrike extends Skills {

	public static String name = "Blinding Strike";
	public static String descr = "User strikes at a victim's eyes or eye-substitutes. This underhanded maneuver has a chance of inflicting long-term vision impairment.";
	public static String descrShort = "Damages and blinds target.";
	public static int cost = 5;
	public static int baseAcc = 90; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 2;	//Green
	public static int targetType = 0;	//Any Single Target
	public BlindingStrike(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,6);
		if(Math.random() < .6*perp.getBuffedLuk()/vic.getBuffedLuk()){
			bs.bp.stm.addStatus(vic, new Blind(3, perp, 50));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,6);
		if(Math.random() < .6*perp.getBuffedLuk()/vic.getBuffedLuk()){
			bs.bp.stm.addStatus(vic, new Blind((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, 80));	
		}
	}
}
