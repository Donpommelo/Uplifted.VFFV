package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class CrushingSlam extends Skills {

	public String name = "Crushing Slam";
	public String descr = "User slams a target with a\nheavy body,dealing damage and\ndazing.";
	public String descrShort = "Damages and Dazes.";
	public int cost = 8;
	public CrushingSlam(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Crushing Slam!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)*.75){
			bs.bp.bt.textList.add(perp.getName()+" was dazed by the blow!");
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/((int)(vic.buffedStats[3]*.8)),vic);
			for(int i = 0; i<bs.bp.TurnOrderQueue.size(); i++){
				if(bs.bp.TurnOrderQueue.get(i)!=null){
					if(bs.bp.TurnOrderQueue.get(i).user.equals(vic) && !vic.equals(perp)){
						bs.bp.TurnOrderQueue.remove(i);
						i--;
					}
				}
				
			}
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
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