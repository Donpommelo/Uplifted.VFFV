package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Runaway extends Skills {

	public static String name = "Run Away";
	public static String descr = "User attempts to escape.";
	public static String descrShort = "Run away from battle.";
	public static int cost = 0;
	public Runaway(int index) {
		super(index, 1, 6, name, descr, descrShort, cost, Assets.run);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" ran away!");	
		int partyLevel = 0;
		double bonus = 0;
		int enemyLevel = 0;
		for(Schmuck s : bs.bs.alliesSelectable){
			partyLevel += s.getLvl();
			bonus += s.getRunawayBonus();
		}
		for(Schmuck m : bs.bs.enemySelectable){
			enemyLevel += m.getLvl();
		}
		double chance = .8 *(partyLevel/enemyLevel)*(1+bonus);
		if(bs.runnable && Math.random()<=chance){	
			bs.bp.bt.ranAway = true;
		}
		else{
			bs.bp.bt.textList.add("Runaway failed!");
		}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	

}
