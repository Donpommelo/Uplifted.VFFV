package dev.zt.UpliftedVFFV.ablities;

import java.util.ArrayList;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;


public class CleansingSpray extends Skills {

	public static String name = "Cleansing Spray";
	public static String descr = "User douses a victim in caustic detergent, cleaning the target of impurities and the ground of the target.";
	public static String descrShort = "Damages target and removes statuses.";
	public static int cost = 28;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public CleansingSpray(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		int statusesRemoved = 0;
		ArrayList<status> removed = new ArrayList<status>();
		for(status st : vic.statuses){
			if(!st.perm){
				removed.add(st);
			}
		}
		for(status st : removed){
			bs.bp.stm.removeStatus(vic, st);
			statusesRemoved++;
		}
		int damage = (int)(bs.bp.em.logScaleDamage(perp, vic) * statusesRemoved / 5);
		bs.bp.em.hpChange(damage, perp, vic,6);
	}
}
