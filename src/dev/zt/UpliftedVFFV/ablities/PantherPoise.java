package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.PantherPoiseEffect;

public class PantherPoise extends Skills {

	public String name = "Panther Poise";
	public String descr = "User gains the poise of a\npanther and gets ready to do\npanther things.";
	public String descrShort = "Redirects items to self.";
	public int cost = 8;
	public PantherPoise(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Panther Poise!");
		bs.bp.bt.textList.add(perp.getName()+" looks poised to strike!");
		for(Schmuck s : bs.bs.enemyTargets){
			bs.bp.stm.addStatus(s, new PantherPoiseEffect(1,perp));
		}
		for(Schmuck s : bs.bs.alliesTargets){
			bs.bp.stm.addStatus(s, new PantherPoiseEffect(1,perp));
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