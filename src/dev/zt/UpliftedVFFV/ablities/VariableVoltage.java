package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class VariableVoltage extends Skills {

	public static String name = "Variable Voltage";
	public static String descr = "User strikes the enemy team\nwith random bursts of\nelectricity.";
	public static String descrShort = "Deals random Yellow\ndamage to enemies.";
	public static int cost = 15;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 3;	//Yellow
	public static int targetType = 1;	//No Target
	public VariableVoltage(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		Schmuck target3;
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target3 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3])), perp, target1,3);
		if(target1.equals(target2)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)), perp, target2,3);
			if(target2.equals(target3)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target3.buffedStats[3]*4)), perp, target3,3);
			}
			else{
				if(target1.equals(target3)){
					bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target3.buffedStats[3]*2)),perp, target3,3);
				}
			}
		}
		else{
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])),perp, target2,3);
			if(target2.equals(target3)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target3.buffedStats[3]*2)),perp, target3,3);
			}
			else{
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])),perp, target2,3);
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;
		Schmuck target3;
		target1 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target2 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		target3 = bs.bp.getSelectableEnemies(perp).get((int)(Math.random()*bs.bp.getSelectableEnemies(perp).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3])), perp, target1,3);
		if(target1.equals(target2)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/((int)(target2.buffedStats[3])), perp, target2,3);
			if(target2.equals(target3)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*4)/((int)(target3.buffedStats[3])), perp, target3,3);
			}
			else{
				if(target1.equals(target3)){
					bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/((int)(target3.buffedStats[3])),perp, target3,3);
				}
			}
		}
		else{
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])),perp, target2,3);
			if(target2.equals(target3)){
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/((int)(target3.buffedStats[3])),perp, target3,3);
			}
			else{
				bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3])),perp, target2,3);
			}
		}	
	}
				
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return -(int)((Math.random()+.5)*(perp.buffedStats[2]*perp.buffedStats[2])/((int)(perp.buffedStats[3])));
	}

}
