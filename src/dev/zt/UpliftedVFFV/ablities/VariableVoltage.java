package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.VariableVoltageAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class VariableVoltage extends Skills {

	public static String name = "Variable Voltage";
	public static String descr = "User strikes the enemy team with random bursts of electricity.";
	public static String descrShort = "Deals random Yellow damage to enemies.";
	public static int cost = 22;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//No Target
	public static BattleAnimation[] ba = {new VariableVoltageAnim(),new VariableVoltageAnim(),new VariableVoltageAnim(),new VariableVoltageAnim(),new VariableVoltageAnim(),new VariableVoltageAnim(),new VariableVoltageAnim()};
	public VariableVoltage(int index) {
		super(index, targetType, element, name, descr, descrShort, cost,1, baseAcc, baseCrit, canMiss, canCrit,ba);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs, int stage){	
		Schmuck target1 = ba[stage].getTarget();
		int damage = (int)(Math.random() * (bs.bp.em.logScaleDamage(perp, target1)));
		bs.bp.em.hpChange(damage, perp, target1,3);
	}
				
}
