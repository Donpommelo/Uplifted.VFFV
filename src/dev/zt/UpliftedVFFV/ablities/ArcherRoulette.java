package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ArcherRoulette extends Skills {

	public static String name = "Archer Roulette";
	public static String descr = "User fires a powerful missile\nthat is aimed, but only slightly.";
	public static String descrShort = "Deals damage to a random\ntarget with preference for\ntarget.";
	public static int cost = 17;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public ArcherRoulette(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target;
		bs.bp.bt.textList.add(perp.getName()+" used Archer Roulette!");	
		if(Math.random()>.5){
			bs.bp.bt.textList.add(perp.getName()+"'s aim was true!");
			bs.bp.em.hpChange(-(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*.5)),perp,vic,6);
		}
		else{
			target = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
			bs.bp.bt.textList.add(perp.getName()+"'s aim was was off target!");
			bs.bp.em.hpChange(-(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*.5)),perp,target,6);
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Archer Roulette!");	
		bs.bp.bt.textList.add("A Critical Blow!");	
		bs.bp.em.hpChange((int)(damageCalc(perp,vic,bs)*(1.5+perp.getCritMulti()-vic.getCritRes())),perp,vic,6);
	}
	

	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*.5));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,1000);
	}	
}
