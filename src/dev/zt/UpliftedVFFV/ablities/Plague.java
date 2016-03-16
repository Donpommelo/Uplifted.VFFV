package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Contagious;


public class Plague extends Skills {

	public static String name = "Plague";
	public static String descr = "User infects target, causing them to spread other illness to allies with disgusting sneezes and coughs.\nAlways wash your hands.";
	public static String descrShort = "Inflicts Contagious on target.";
	public static int cost = 16;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 2;	//Green
	public static int targetType = 0;	//Any Single Target
	public Plague(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new Contagious(4, perp, vic,50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new Contagious((int)(4*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,50));	
	}
}
