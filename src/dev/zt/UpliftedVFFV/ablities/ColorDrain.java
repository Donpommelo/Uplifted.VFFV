package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuffMult;

public class ColorDrain extends Skills {

	public static String name = "Color Drain";
	public static String descr = "User sucks the elemental alignments\nfrom a targeted foe, dealing damage\n and restoring health.";
	public static String descrShort = "Lowers elemental alignment and\ndrains Hp if targeting an enemy.";
	public static int cost = 30;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public ColorDrain(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Color Drain!");
		for(int i = 0; i < 5; i++){
			bs.bp.stm.addStatus(vic, new ElemPointsBuffMult(5,i,.9,perp,50));
		}
		if(bs.bp.getSelectableEnemies(perp).contains(vic)){
			int damage = -(4*perp.buffedStats[2]*perp.buffedStats[2]/5)/vic.buffedStats[3];
			bs.bp.em.hpChange(damage, perp, vic,6);
			bs.bp.em.hpChange((int)(-damage*(1+perp.getHealPower())), perp, perp,6);
		}
	}

	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2]*4)/(int)(vic.buffedStats[3]*5);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
}