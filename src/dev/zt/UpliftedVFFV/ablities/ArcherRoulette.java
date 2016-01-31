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
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public ArcherRoulette(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target;
		if(Math.random()>.5){
			bs.bp.bt.addScene(perp.getName()+"'s aim was true!");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*1.25);
			bs.bp.em.hpChange(damage,perp,vic,6);
		}
		else{
			target = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
			bs.bp.bt.addScene(perp.getName()+"'s aim was was off target!");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, target)*1.25);
			bs.bp.em.hpChange(damage,perp,target,6);
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target;
		if(Math.random()>.5){
			bs.bp.bt.addScene(perp.getName()+"'s aim was true!");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes())*1.25);
			bs.bp.em.hpChange(damage,perp,vic,6);
		}
		else{
			target = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
			bs.bp.bt.addScene(perp.getName()+"'s aim was was off target!");
			int damage = (int)(bs.bp.em.logScaleDamage(perp, target)*(1.5+perp.getCritMulti()-target.getCritRes())*1.25);
			bs.bp.em.hpChange(damage,perp,target,6);
			}
		}
		
}
