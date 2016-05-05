package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.FlexileStrikeAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TriStrike extends Skills {

	public static String name = "Tristrike";
	public static String descr = "User strikes a foe three successive times.";
	public static String descrShort = "Damages target three times.";
	public static int cost = 7;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public static BattleAnimation[] ba = {new FlexileStrikeAnim(),new FlexileStrikeAnim(),new FlexileStrikeAnim()};
	public TriStrike(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 1,baseAcc, baseCrit, canMiss, canCrit,ba);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs, int stage){			
		int damage1 = (int)(bs.bp.em.logScaleDamage(perp,vic) * 0.3);
		bs.bp.em.hpChange(damage1, perp, vic,6);
		
	}
			
}
