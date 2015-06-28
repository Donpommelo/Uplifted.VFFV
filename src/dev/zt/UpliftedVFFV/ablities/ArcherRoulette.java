package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class ArcherRoulette extends Skills {

	public String name = "Archer Roulette";
	public String descr = "User fires a powerful missile\nthat is aimed, but onlyslightly.";
	public String descrShort = "Deals damage to a random\ntarget with preference for\ntarget.";
	public int cost = 17;
	public ArcherRoulette(int index) {
		super(index);

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
