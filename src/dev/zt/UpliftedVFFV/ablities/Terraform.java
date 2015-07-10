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
	public Terraform(int index) {
		super(index,1,2, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Terraform");
		bs.bp.bt.textList.add("All battlers look discombobulated.");
		for(Schmuck s : bs.bp.getEnemyTargets(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(s.buffedStats[3]*2), perp, s);
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
		for(Schmuck s : bs.bp.getEnemyTargets(perp)){
			bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1+perp.getCritMulti())), perp, s);
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
	
	public int getTargetType(){
		return targetType;
	}

}
