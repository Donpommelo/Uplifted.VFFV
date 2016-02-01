package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;
import dev.zt.UpliftedVFFV.statusEffects.Stats.ElemPointsBuff;
public class PennyBlue extends Skills {

	public static String name = "Penny Blue";
	public static String descr = "User grants a target a\nBlue-aligned shield that\nregenerates health and\nbolsters Red resistance.";
	public static String descrShort = "Heals and boosts Mp regeneration.";
	public static int cost = 15;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 1;	//Blue
	public static int targetType = 0;	//Any Single Target
	public PennyBlue(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange((int)(perp.getBuffedInt()*(1+perp.getHealPower())), perp, vic, 1);
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(3,1,20,perp,50));
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 35, vic.getMaxBp()/10, perp, 50));
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange((int)(1.5*perp.getBuffedInt()*(1+perp.getHealPower())), perp, vic, 1);
		bs.bp.stm.addStatus(vic, new ElemPointsBuff(3,1,(int)(10 * (1.5+perp.getCritMulti())),perp,50));
		bs.bp.stm.addStatus(vic, new BonusStatBuff(3, 35,(int)(vic.getMaxBp()/10*(1.5+perp.getCritMulti())), perp, 50));
	}
	
	public boolean startTarget(){
		return true;
	}
}
