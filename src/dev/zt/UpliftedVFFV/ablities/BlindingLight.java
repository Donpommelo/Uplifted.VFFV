package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Blind;

public class BlindingLight extends Skills {

	public static String name = "Blinding Light";
	public static String descr = "User creates a bright flash of luminosity, blinding and dazzling all enemies that dare look.";
	public static String descrShort = "Chance to Blind all enemies.";
	public static int cost = 18;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public BlindingLight(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			if(Math.random() < .6*perp.getBuffedLuk()/s.getBuffedLuk()){
				bs.bp.stm.addStatus(s, new Blind(3, perp, s,50));
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			if(Math.random() < .6*perp.getBuffedLuk()/s.getBuffedLuk()){
				bs.bp.stm.addStatus(s, new Blind((int)(3*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, s,80));	
			}
		}		
	}

}
