package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.FlexileStrikeAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class FlexileStrike extends Skills {

	public static String name = "Flexile Strike";
	public static String descr = "User utilizes a flexible appendage to strike foes multiple times.";
	public static String descrShort = "Damages two random enemies.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public static BattleAnimation[] ba = {new FlexileStrikeAnim(),new FlexileStrikeAnim()};
	public FlexileStrike(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 1,baseAcc, baseCrit, canMiss, canCrit,ba);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs, int stage){	
		Schmuck target1 = ba[stage].getTarget();
		
		int damage1 = (int)(bs.bp.em.logScaleDamage(perp, target1) * 0.9);
		bs.bp.em.hpChange(damage1, perp, target1,6);
		
	}
			
}
