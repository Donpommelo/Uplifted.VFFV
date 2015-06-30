package dev.zt.UpliftedVFFV.ablities;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;


public class ChaosConjure extends Skills {

	public String name = "Chaos Conjure";
	public String descr = "User summons a storm damaging and\n scrambling and damaging foes\nLimit : One use per fight.";
	public String descrShort = "Damages all foes and\nScrambles order\n1 use per fight.";
	public int cost = 5;
	public ChaosConjure(int index) {
		super(index,1);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Chaos Conjure!");
		bs.bp.bt.textList.add("All battlers were discombobulated!");
			bs.bp.stm.addStatus(perp, new LimitedUse(0,this,0, perp));
			for(Schmuck s : bs.bp.getEnemyTargets(perp)){
				bs.bp.em.hpChange(-15, perp, s);
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
		
	}

	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
	public int getTargetType(){
		return targetType;
	}

}
