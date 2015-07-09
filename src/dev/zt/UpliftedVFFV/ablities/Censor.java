package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;


public class Censor extends Skills {

	public static String name = "Censor";
	public static String descr = "User harshly Censors a for, causing\nthem to be unable to cast\nspecial abilities.";
	public static String descrShort = "Silences target.";
	public static int cost = 10;
	public Censor(int index) {
		super(index, 0, 6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Censor!");
		int hitChance = (int)(Math.random()*100);
		if(hitChance<bs.bp.em.getAcc(perp, vic)){
			bs.bp.stm.addStatus(vic, new Silenced(3, perp));
		}
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" used Censor!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.stm.addStatus(vic, new Silenced((int)(3*(1.5+perp.getCritMulti())), perp));	
	}
}
