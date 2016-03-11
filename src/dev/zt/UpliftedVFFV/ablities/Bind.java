package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Channeling;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class Bind extends Skills {

	public static String name = "Bind";
	public static String descr = "User expends great effort to hold a victim in place. Unless focus is broken, both victim and perpetrator are condemned to extended immobility.";
	public static String descrShort = "Binds target for several turns.";
	public static int cost = 15;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public Bind(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		status st = new Stunned(5,perp,50);
		bs.bp.stm.addStatus(vic, st);
		bs.bp.stm.addStatus(perp, new Channeling(perp.getMaxHp()/4,15,st,false,false,true,perp,vic,50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		status st = new Stunned(5,perp,50);
		bs.bp.stm.addStatus(vic, st);
		bs.bp.stm.addStatus(perp, new Channeling(perp.getMaxHp()/4,15,st,false,false,true,perp,vic,50));
	}
}
