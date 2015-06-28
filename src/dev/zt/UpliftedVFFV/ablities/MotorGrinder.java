package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class MotorGrinder extends Skills {

	public String name = "Motorgrinder";
	public String descr = "User summons crushing gears to\nbatter a foe and lower the\ntarget's Defense.";
	public String descrShort = "Damage and lower Def.";
	public int cost = 7;
	public MotorGrinder(int index) {
		super(index);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Motorgrinder!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<.8*bs.bp.em.getAcc(perp, vic)){
			bs.bp.stm.addStatus(vic, new TestStatBuff(2,3,.8, perp));
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2), perp, vic);
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
