package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Poach extends Skills {

	public static String name = "Poach";
	public static String descr = "User poaches target, finish description later.";
	public static String descrShort = "Deals damage and prevents item usage.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public Poach(int index) {
		super(index,0,6, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Poach!");
		bs.bp.em.hpChange((int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.5))/vic.buffedStats[3], perp, vic,6);
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i)!=null){
				if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && bs.bp.TurnOrderQueue.get(i).getSkill().getName().equals("Use Item")){
					bs.bp.bt.textList.add(vic.getName()+"'s item was Poached!");
					bs.bp.TurnOrderQueue.remove(i);
					i--;
				}
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Poach!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.2+perp.getCritMulti())), perp, vic,6);	
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i)!=null){
				if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && bs.bp.TurnOrderQueue.get(i).getSkill().getName().equals("Use Item")){
					bs.bp.bt.textList.add(vic.getName()+"'s item was Poached!");
					bs.bp.TurnOrderQueue.remove(i);
					i--;
				}
			}
		}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2]*.5)/(int)(vic.buffedStats[3]);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}

}
