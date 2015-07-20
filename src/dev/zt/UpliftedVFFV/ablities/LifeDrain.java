package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class LifeDrain extends Skills {

	public static String name = "Life Drain";
	public static String descr = "User sucks the lifeforce from a\ntargeted foe, dealing damage\n and restoring health.";
	public static String descrShort = "Damages target and heals\nself.";
	public static int cost = 7;
	public LifeDrain(int index) {
		super(index,0,6, name, descr, descrShort, cost);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Life Drain!");
		if(bs.bp.em.getAcc(perp, vic,100)){
			bs.bp.em.hpChange(-(4*perp.buffedStats[2]*perp.buffedStats[2]/5)/vic.buffedStats[3], perp, vic,6);
			bs.bp.em.hpChange((int)((perp.buffedStats[2]*perp.buffedStats[2]*(1+perp.getHealPower()))/(vic.buffedStats[3]*2)), perp, perp,6);
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Life Drain!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.2*perp.getCritMulti())), perp, vic,6);
		bs.bp.em.hpChange((int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.2*perp.getCritMulti())), vic, perp,6);
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2]*4)/(int)(vic.buffedStats[3]*5);
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
}
