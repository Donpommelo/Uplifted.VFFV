package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class BlightBite extends Skills {

	public String name = "Blight Bite";
	public String descr = "User refrains from brushi\nhis/her teeth and bites an\nenemy.";
	public String descrShort = "Damages and poisons target.";
	public int cost = 5;
	public BlightBite(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Blight Bite!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<.8*bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3],vic);
			bs.bp.stm.addStatus(vic, new Regendegen(3,true,-3));
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
