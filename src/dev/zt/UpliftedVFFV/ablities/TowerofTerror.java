package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Fear;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;

public class TowerofTerror extends Skills {

	public static String name = "Tower of Terror";
	public static String descr = "TEMP";
	public static String descrShort = "Damages and inflicts Fear.";
	public static int cost = 35;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 0;	//Red
	public static int targetType = 0;	//Any Single Target
	public TowerofTerror(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,0);
		bs.bp.stm.addStatus(vic, new Fear(3, perp,vic,perp,50));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,0);
		bs.bp.stm.addStatus(vic, new Fear((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,perp, 50));	
	}

}
