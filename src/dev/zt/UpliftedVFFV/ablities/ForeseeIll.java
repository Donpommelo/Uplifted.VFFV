package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class ForeseeIll extends Skills {

	public static String name = "Foresee Ill";
	public static String descr = "User brings bad tidings to a\ntargeted foe, dealing heavy\ndamage that scales with target's\nIntrusive Thoughts.";
	public static String descrShort = "Release built up Intrusive\nThoughts.";
	public static int cost = 4;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public ForeseeIll(int index) {
		super(index,0,4, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" Foresees Ill!");
		int stacked = -1;
		for(status s : vic.statuses){
			if(s.getName().equals("Intrusive Thoughts")){
				stacked = vic.statuses.indexOf(s);
			}					
		}
		if(stacked != -1){
			bs.bp.em.hpChange(-(int)Math.pow(2, vic.statuses.get(stacked).stack)+1, perp, vic,6);
			bs.bp.stm.removeStatus(vic, vic.statuses.get(stacked));
		}
		else{
			bs.bp.bt.textList.add("But it failed.");
		}
	}

}
