package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.SindhDakStatus;

public class SindhDak extends Skills {

	public static String name = "Sindh Dak";
	public static String descr = "User grants a target a buff that causes their next targeted ability to affect whole team.";
	public static String descrShort = "Target's next ability splashes.";
	public static int cost = 38;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public SindhDak(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new SindhDakStatus(3, perp, vic,10));
		bs.bp.bt.addScene(vic.getName()+" is ready to spread the message!");
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.stm.addStatus(vic, new SindhDakStatus((int)(3*(1+perp.getCritMulti()-vic.getCritRes())), perp, vic, 20));	
		bs.bp.bt.addScene(vic.getName()+" is ready to spread the message!");
	}
	
	public boolean startTarget(){
		return true;
	}

}
