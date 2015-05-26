package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DoubleGeneva extends Skills {

	public String name = "Double Geneva";
	public String descr = "User summons a barrage of\nmissles and will do massive damage\n to unscathed target.";
	public String descrShort = "Damages two random foes.\nIf this attack targeted\nneither,target is damaged. ";
	public int cost = 12;
	public DoubleGeneva(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target1;
		Schmuck target2;
		bs.bp.bt.textList.add(perp.getName()+" used Double Geneva!");
		if(bs.bp.bm.enemy.contains(vic)){
			target1 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
			target2 = bs.bs.enemyTargets.get((int)(Math.random()*bs.bs.enemyTargets.size()));
		}
		else{
			target1 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
			target2 = bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size()));
		}
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*2)),target1);
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target2.buffedStats[3]*2)),target2);
		if(!vic.equals(target1) && !vic.equals(target2)){
			bs.bp.bt.textList.add(vic.getName()+"'s diplomatic immunity expires!");
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target1.buffedStats[3]*.5)),vic);
		}

	}
		
	public String getName(){
		return name;
	}
	
	public String getDescr() {
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}
	

}
