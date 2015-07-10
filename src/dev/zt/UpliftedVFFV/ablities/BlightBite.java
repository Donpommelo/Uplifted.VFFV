package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Regendegen;

public class BlightBite extends Skills {

	public static String name = "Blight Bite";
	public static String descr = "User refrains from brushi\nhis/her teeth and bites an\nenemy.";
	public static String descrShort = "Damages and poisons target.";
	public static int cost = 5;
	public BlightBite(int index) {
		super(index, 0, 6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Blight Bite!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<.8*bs.bp.em.getAcc(perp, vic)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3],perp,vic);
			bs.bp.stm.addStatus(vic, new Regendegen(3,true,-3, perp));
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Blight Bite!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti())), perp, vic);
		bs.bp.stm.addStatus(vic, new Regendegen((int)(3*(1.5+perp.getCritMulti())),true,-3, perp));	
	}
}
