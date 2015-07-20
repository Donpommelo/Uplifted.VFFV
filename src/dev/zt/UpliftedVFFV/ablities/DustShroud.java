package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.LimitedUse;
import dev.zt.UpliftedVFFV.statusEffects.Untouchable;


public class DustShroud extends Skills {

	public static String name = "Dust Shroud";
	public static String descr = "User summons a blinding cloud that renders\nall teamates untargetable.";
	public static String descrShort = "Makes allies untargetable\n1 use per fight.";
	public static int cost = 10;
	public DustShroud(int index) {
		super(index,1,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Dust Shroud!");
		bs.bp.bt.textList.add("All allies became Untargetable!");
			bs.bp.stm.addStatus(perp, new LimitedUse(0,this,0, perp));
			for(Schmuck s : bs.bp.getSelectableAllies(perp)){
				bs.bp.stm.addStatus(s, new Untouchable(2, perp));
			}
	}
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
}
