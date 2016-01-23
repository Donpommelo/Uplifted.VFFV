package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;
import dev.zt.UpliftedVFFV.statusEffects.Stats.StatBuffMult;


public class Petrify extends Skills {

	public static String name = "Petrify";
	public static String descr = "User petrifies a target, disabling\nthem for a long duration\nLimit : One use per fight.";
	public static String descrShort = "Stuns target\n1 use per fight.";
	public static int cost = 10;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss =  false; public static boolean canCrit = false;
	public static int element = 2;	//Green
	public static int targetType = 0;	//Any Single Target
	public Petrify(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.addScene(vic.getName()+" was petrified!");
		bs.bp.stm.addStatus(perp, new LimitedUse(this,0, perp, 50));
		bs.bp.stm.addStatus(vic, new Stunned(2,perp, 60));	
		bs.bp.stm.addStatus(vic, new StatBuffMult(2,3,1.5,perp,10));
	}	
}
