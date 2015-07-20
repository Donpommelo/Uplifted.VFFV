package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class BoxCutter extends Skills {

	public static String name = "Box Cutter";
	public static String descr = "A quick and reliable stab with a\nbox-opening blade. This attack\nwill deal consistent damage\nscaling to its user's Level.";
	public static String descrShort = "Weak single target attack\nthat never misses.";
	public static int cost = 1;
	public BoxCutter(int index) {
		super(index, 0 , 6 , name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Box Cutter!");
		bs.bp.em.hpChange(-(perp.Lvl*2+5),perp,vic,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return -(perp.Lvl*2+5);
	}
}
