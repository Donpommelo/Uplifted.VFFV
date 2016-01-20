package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Runaway extends Skills {

	public static String name = "Run Away";
	public static String descr = "User attempts to escape.";
	public static String descrShort = "Run away from battle.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Runaway(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 5, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int partyLevel = 0;
		double bonus = 0;
		int enemyLevel = 0;
		for(Schmuck s : bs.bs.alliesSelectable){
			partyLevel += s.getLvl();
			bonus += s.getRunawayBonus();
		}
		for(Schmuck m : bs.bs.enemySelectable){
			enemyLevel += (m.getLvl());
		}
		partyLevel /= bs.bs.alliesSelectable.size();
		enemyLevel /= bs.bs.enemySelectable.size();
		double chance = (partyLevel/enemyLevel)*(1+bonus);
		if(bs.runnable && Math.random() <= chance){
			bs.bp.stm.endofFite();
			bs.end(false);
		}
		else{
			bs.bp.bt.addScene("Runaway failed!");
		}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return 	perp.getName()+" Ran Away!";
	}
}
