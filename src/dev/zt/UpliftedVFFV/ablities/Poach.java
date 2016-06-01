package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Poach extends Skills {

	public static String name = "Poach";
	public static String descr = "User makes a target more likely to be a member of an endangdered species. User also poaches any attempted item-use while he or she is at it.";
	public static String descrShort = "Deals damage and prevents item usage.";
	public static int cost = 1;
	public static int baseAcc = 80; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 0;	//Physical
	public static int targetType = 0;	//No Target
	public Poach(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic));
		bs.bp.em.hpChange(damage, perp, vic,6);
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i)!=null){
				if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && bs.bp.TurnOrderQueue.get(i).getSkill().getName().equals("Use Item")){
					bs.bp.bt.addScene(vic.getName()+"'s item was Poached!");
					bs.bp.TurnOrderQueue.remove(i);
					i--;
				}
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic)*(1.5+perp.getCritMulti()-vic.getCritRes()));
		bs.bp.em.hpChange(damage, perp, vic,6);
		for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
			if(bs.bp.TurnOrderQueue.get(i)!=null){
				if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && bs.bp.TurnOrderQueue.get(i).getSkill().getName().equals("Use Item")){
					bs.bp.bt.addScene(vic.getName()+"'s item was Poached!");
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

}
