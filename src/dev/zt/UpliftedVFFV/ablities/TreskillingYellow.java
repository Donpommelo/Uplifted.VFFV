package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleProcessor;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class TreskillingYellow extends Skills {

	public String name = "Treskilling Yellow";
	public String descr = "User strikes for with a bolt.\nof aether that tends to gain\ninitiative.";
	public String descrShort = "Deals Yellow damage and\nhits first.";
	public int cost = 5;
	public TreskillingYellow(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Treskilling Yellow!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange((int)(-(perp.buffedStats[2]*perp.buffedStats[2]*.6))/vic.buffedStats[3],vic,3);
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
	
	public void TOQChange(Action a, BattleState bs){
		bs.bp.TurnOrderQueue.remove(a);
		bs.bp.TurnOrderQueue.add(0, a);
	}
	

}
