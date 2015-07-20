package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TreskillingYellow extends Skills {

	public static String name = "Treskilling Yellow";
	public static String descr = "User strikes foe with a bolt.\nof aether that tends to gain\ninitiative.";
	public static String descrShort = "Deals Yellow damage and\nhits first.";
	public static int cost = 5;
	public TreskillingYellow(int index) {
		super(index,0,3, name, descr, descrShort, cost);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Treskilling Yellow!");
		if(bs.bp.em.getAcc(perp, vic,100)){
			bs.bp.em.hpChange((int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.6))/vic.buffedStats[3],perp, vic,3);
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Treskilling Yellow!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2]*.6)/vic.buffedStats[3])*(1.5+perp.getCritMulti())), perp, vic,3);
				
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = (int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.6))/vic.buffedStats[3];
		return bs.bp.em.damageSimulation(damage, perp, vic, 3,100);
	}

}
