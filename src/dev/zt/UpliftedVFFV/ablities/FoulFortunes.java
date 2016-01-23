package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class FoulFortunes extends Skills {

	public static String name = "Foul Fortune";
	public static String descr = "User curses a foe\nlowering their Luck.";
	public static String descrShort = "Lowers single targets Luk\n";
	public static int cost = 8;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public FoulFortunes(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new StatBuffMult(4,7,.75, perp,60));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new StatBuffMult((int)(4*(1.5+perp.getCritMulti()-vic.getCritRes())),2,.75, perp,60));
	}
}
