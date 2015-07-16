package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoubleGeneva extends Skills {

	public static String name = "Double Geneva";
	public static String descr = "User summons a barrage of\nmissles and will do massive damage\n to unscathed target.";
	public static String descrShort = "Damages two random foes.\nIf this attack targeted\nneither,target is damaged. ";
	public static int cost = 12;
	public DoubleGeneva(int index) {
		super(index,0,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Double Geneva!");
		target1 = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
		target2 = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp,target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)), perp, target2);
		if(!vic.equals(target1) && !vic.equals(target2)){
			bs.bp.bt.textList.add(vic.getName()+"'s diplomatic immunity expires!");
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*.5)),perp, vic);
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Double Geneva!");
		bs.bp.bt.textList.add("A Critical blow!");
		target1 = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
		target2 = bs.bp.getSelectableAllies(vic).get((int)(Math.random()*bs.bp.getSelectableAllies(vic).size()));
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)), perp,target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)), perp, target2);
		bs.bp.bt.textList.add(vic.getName()+"'s diplomatic was critically rejected!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*.5)),perp, vic);
	}

}
