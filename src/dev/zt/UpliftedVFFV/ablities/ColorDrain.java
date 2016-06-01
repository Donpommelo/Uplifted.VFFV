package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;

public class ColorDrain extends Skills {

	public static String name = "Color Drain";
	public static String descr = "User sucks the color from a target. Color Draining is an excruciating process, although this pain can be assuaged through relaxation and the proper mindset.";
	public static String descrShort = "Lowers elemental alignment and damages if targeting an enemy.";
	public static int cost = 30;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public ColorDrain(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(int i = 0; i < 5; i++){
			bs.bp.stm.addStatus(vic, new ElemPointsBuffMult(5,i,.9,perp,vic,50));
		}
		if(bs.bp.getSelectableEnemies(perp).contains(vic)){
			int damage = (int)(bs.bp.em.logScaleDamage(perp, vic) * 0.8);
			bs.bp.em.hpChange(damage, perp, vic,6);
		}
	}
}
