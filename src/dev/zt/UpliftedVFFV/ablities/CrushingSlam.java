package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;

public class CrushingSlam extends Skills {

	public static String name = "Crushing Slam";
	public static String descr = "User slams a target with a heavy body, potentially knocking victims off-balance.";
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
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic) * 0.8);
		bs.bp.em.hpChange(damage, perp, vic,6);
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
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()) * 0.8);
		bs.bp.em.hpChange(damage, perp, vic,6);
		bs.bp.stm.addStatus(vic, new Stunned(2,perp, 80));
	}
}
