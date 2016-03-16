package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;

public class BlightBite extends Skills {

	public static String name = "Blight Bite";
	public static String descr = "User attacks victim with filthy and sharp teeth. Those who practice poor personal hygiene may be trying to give their Blight Bite a higher chance of inflicting Poison.";
	public static String descrShort = "Damages and poisons target.";
	public static int cost = 5;
	public static int baseAcc = 90; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public BlightBite(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,6);		
		if(Math.random() < .6*perp.getBuffedLuk()/vic.getBuffedLuk()){
			bs.bp.stm.addStatus(vic, new Poisoned(3, perp, vic,40));
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,6);
		if(Math.random() < .6*perp.getBuffedLuk()/vic.getBuffedLuk()){
			bs.bp.stm.addStatus(vic, new Poisoned((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,80));	
		}
	}

}
