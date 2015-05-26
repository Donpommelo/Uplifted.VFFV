package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class DamnedDescent extends Skills {

	public String name = "Damned Descent";
	public String descr = "User drops a target a considerable\ndistance. If this attack\nincapacitates a foe, the\nuser gains an extra turn.";
	public String descrShort = "Deals Red damage and\nrefunds turn if lethal.";
	public int cost = 11;
	public DamnedDescent(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Damned Descent!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<.8*bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*1.5),vic,0);
			if(vic.tempStats[0]==0){
				bs.bp.bt.textList.add(perp.getName()+"'s sin is repaid!");
				bs.bp.TurnOrderQueue.add(new Action(perp,perp,new DillyDally(0),bs));
			}
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
		
	}

	
	public String getName(){
		return name;
	}
	
	public String getDescr(){
		return descr;
	}
	
	public String getDescrShort() {
		return descrShort;
	}
	
	public int getCost(){
		return cost;
	}


}
