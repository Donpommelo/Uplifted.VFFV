package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class Haunt extends Skills {

	public static String name = "Haunt";
	public static String descr = "User returns from the grave\nto damage and unnerve foes.";
	public static String descrShort = "Damages and debuffs all enemies.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Haunt(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/(s.buffedStats[3]*10), perp, s,6);
			bs.bp.stm.addStatus(s, new TestStatBuff(5,3,.9,perp,80));
		}
	}
		
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/(s.buffedStats[3]*5),perp,s,6,1000);
		}
		return damage;
	}
}
