package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;


public class ForceWithin extends Skills {

	public static String name = "Force Within";
	public static String descr = "User channels a powerful force at\nfoes, dazing all enemies\nLimit : One use per fight.";
	public static String descrShort = "Dazes all foes\n1 use per fight.";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public ForceWithin(int index) {
		super(index,1,6, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Force Within!");
		bs.bp.bt.textList.add("All enemies were dazed!");
			bs.bp.stm.addStatus(perp, new LimitedUse(0,this,0, perp, 50));
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
					if(bs.bp.TurnOrderQueue.get(i)!=null){
						if(bs.bp.TurnOrderQueue.get(i).user.equals(s) && !s.equals(perp)){
							bs.bp.TurnOrderQueue.remove(i);
							i--;
						}
					}
				}
			}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}

}
