package dev.zt.UpliftedVFFV.ablities;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Terraform extends Skills {

	public static String name = "Terraform";
	public static String descr = "User shakes the very foundation\nof the building, scrambling\nremaining Turn Order";
	public static String descrShort = "Damages and scrambles\nTurn Order";
	public static int cost = 18;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public Terraform(int index) {
		super(index,1,2, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Terraform");
		bs.bp.bt.textList.add("All battlers look discombobulated.");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(s.buffedStats[3]*2), perp, s,6);
		}
		ArrayList<Action> temp = new ArrayList<Action>();
		bs.bp.TurnOrderQueue.remove(0);
		for(Action a : bs.bp.TurnOrderQueue){
			temp.add(a);
		}
		bs.bp.TurnOrderQueue.clear();
		while(!temp.isEmpty()){
			int rand = (int)(Math.random()*temp.size());
			bs.bp.TurnOrderQueue.add(temp.get(rand));
			temp.remove(rand);
		}
		bs.bp.TurnOrderQueue.add(0, new Action(perp, vic, new Terraform(0), bs));
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Terraform");
		bs.bp.bt.textList.add("All battlers look critically discombobulated.");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1+perp.getCritMulti()-vic.getCritRes())), perp, s,6);
		}
		ArrayList<Action> temp = new ArrayList<Action>();
		bs.bp.TurnOrderQueue.remove(0);
		for(Action a : bs.bp.TurnOrderQueue){
			temp.add(a);
		}
		bs.bp.TurnOrderQueue.clear();
		while(!temp.isEmpty()){
			int rand = (int)(Math.random()*temp.size());
			bs.bp.TurnOrderQueue.add(temp.get(rand));
			temp.remove(rand);
		}
		bs.bp.TurnOrderQueue.add(0, new Action(perp, vic, new Terraform(0), bs));	
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/(s.buffedStats[3]),perp,s,6,1000);
		}
		return damage;
	}

}
