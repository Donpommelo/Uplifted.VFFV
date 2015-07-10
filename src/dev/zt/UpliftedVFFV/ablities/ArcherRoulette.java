package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ArcherRoulette extends Skills {

	public static String name = "Archer Roulette";
	public static String descr = "User fires a powerful missile\nthat is aimed, but only slightly.";
	public static String descrShort = "Deals damage to a random\ntarget with preference for\ntarget.";
	public static int cost = 17;
	public ArcherRoulette(int index) {
		super(index, 0, 6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck target;
		bs.bp.bt.textList.add(perp.getName()+" used Archer Roulette!");	
		if(Math.random()>.5){
			bs.bp.bt.textList.add(perp.getName()+"'s aim was true!");
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3]*.5)),perp,vic);
		}
		else{
			target = bs.bp.getAlliedTargets(vic).get((int)(Math.random()*bs.bp.getAlliedTargets(vic).size()));
			bs.bp.bt.textList.add(perp.getName()+"'s aim was was off target!");
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(target.buffedStats[3]*.5)),perp,target);
			
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Archer Roulette!");	
		bs.bp.bt.textList.add("A Critical Blow!");	
		bs.bp.em.hpChange((int)(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3]*.5))*(1.5+perp.getCritMulti())),perp,vic);
	}
	
}
