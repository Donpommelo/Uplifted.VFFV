package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;

public class Ennervate extends Skills {

	public static String name = "Ennervate";
	public static String descr = "User radiates a fatiguing aura that causes a victim's willpower to deteriorate.";
	public static String descrShort = "Lowers single targets Pow and Spd.";
	public static int cost = 4;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public Ennervate(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new StatBuffMult(2,2,.9, perp,vic,60));
		bs.bp.stm.addStatus(vic, new StatBuffMult(2,4,.9, perp,vic,60));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new StatBuffMult((int)(2*(1.5+perp.getCritMulti()-vic.getCritRes())),2,.9, perp,vic,60));
		bs.bp.stm.addStatus(vic, new StatBuffMult((int)(2*(1.5+perp.getCritMulti()-vic.getCritRes())),4,.9, perp,vic,60));		
	}
}
