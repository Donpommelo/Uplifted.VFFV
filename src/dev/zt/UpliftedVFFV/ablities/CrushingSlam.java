package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stunned;

public class CrushingSlam extends Skills {

	public static String name = "Crushing Slam";
	public static String descr = "User slams a target with a\nheavy body,dealing damage and\ndazing.";
	public static String descrShort = "Damages and Dazes.";
	public static int cost = 8;
	public CrushingSlam(int index) {
		super(index,0,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Crushing Slam!");
		if(bs.bp.em.getAcc(perp, vic,80)){
			bs.bp.bt.textList.add(vic.getName()+" was dazed by the blow!");
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3]*.8)), perp, vic,6);
			for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
				if(bs.bp.TurnOrderQueue.get(i)!=null){
					if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp)){
						bs.bp.TurnOrderQueue.remove(i);
						i--;
					}
				}
				
			}
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Crushing Slam!");
		bs.bp.bt.textList.add(vic.getName()+" was critically dazed by the blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti())), perp, vic,6);
		bs.bp.stm.addStatus(vic, new Stunned(2,perp));
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)((perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*.8));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,80);
	}
}
