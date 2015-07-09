package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class VariableVoltage extends Skills {

	public static String name = "Variable Voltage";
	public static String descr = "User strikes the enemy team\nwith random bursts of\nelectricity.";
	public static String descrShort = "Deals random Yellow\ndamage to enemies.";
	public static int cost = 15;
	public VariableVoltage(int index) {
		super(index,1,3, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		Schmuck target3;
		bs.bp.bt.textList.add(perp.getName()+" used Variable Voltage!");
		target1 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target2 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target3 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
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
		bs.bp.bt.textList.add(perp.getName()+" used Variable Voltage!");
		bs.bp.bt.textList.add("A Critical blow!");
		target1 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target2 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
		target3 = bs.bp.getEnemyTargets(perp).get((int)(Math.random()*bs.bp.getEnemyTargets(perp).size()));
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
			
	public int getTargetType(){
		return targetType;
	}
	

}
