package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.TyrianPlumEffect;

public class TyrianPlum extends Skills {

	public static String name = "Tyrian Plum";
	public static String descr = "User plants a seed into a target\nthat saps health over time.";
	public static String descrShort = "Drains health from target\nwhen using Mp";
	public static int cost = 13;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 2;	//Green
	public static int targetType = 0;	//Any Single Target
	public TyrianPlum(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new TyrianPlumEffect(6,perp, 70));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new TyrianPlumEffect((int)(6*(1+perp.getCritMulti()-vic.getCritRes())),perp, 70));	
	}

}
