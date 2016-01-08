package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;

public class CrushingSlam extends Skills {

	public static String name = "Crushing Slam";
	public static String descr = "User slams a target with a\nheavy body,dealing damage and\ndazing.";
	public static String descrShort = "Damages and Dazes.";
	public static int cost = 8;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public CrushingSlam(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3]*.8)), perp, vic,6);
		if(Math.random()*perp.getBuffedLuk()/vic.getBuffedLuk() >= .25){
			bs.bp.bt.addScene(vic.getName()+" was dazed by the blow!");
			for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
				if(bs.bp.TurnOrderQueue.get(i)!=null){
					if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp)){
						bs.bp.TurnOrderQueue.remove(i);
						i--;
					}
				}
			}
		}	
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,6);
		bs.bp.stm.addStatus(vic, new Stunned(2,perp, 80));
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*.8));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,80);
	}
}
