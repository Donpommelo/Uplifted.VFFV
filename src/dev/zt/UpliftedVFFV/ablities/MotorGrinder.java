package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class MotorGrinder extends Skills {

	public static String name = "Motorgrinder";
	public static String descr = "User summons crushing gears to\nbatter a foe and lower the\ntarget's Defense.";
	public static String descrShort = "Damage and lower Def.";
	public static int cost = 7;
	public MotorGrinder(int index) {
		super(index,0,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Motorgrinder!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<.8*bs.bp.em.getAcc(perp, vic)){
			bs.bp.stm.addStatus(vic, new TestStatBuff(2,3,.8, perp,60));
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(vic.buffedStats[3]*2), perp, vic);
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Motorgrinder!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new TestStatBuff(2,3,(int)(.8*(1-perp.getCritMulti())), perp,60));
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*perp.getCritMulti()), perp, vic);
	}

}
