package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ArcherRoulette extends Skills {
	
	public static String name = "Archer Roulette";
	public static String descr = "User produces a powerful projectile. While the user attempts to direct this attack, it may misfire and striking a different enemy than the one intended.";
	public static String descrShort = "Powerful attack with a chance to hit wrong enemy.";
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
			int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*1.5);
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
