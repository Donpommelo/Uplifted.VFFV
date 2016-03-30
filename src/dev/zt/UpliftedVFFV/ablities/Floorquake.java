package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class Floorquake extends Skills {

	public static String name = "Floorquake";
	public static String descr = "";
	public static String descrShort = "Damages all enemies.\nSpecial effect with floor.";
	public static int cost = 17;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public Floorquake(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		switch(bs.gs.getVar(1)){
		case 0:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 1:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 2:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 3:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 4:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 5:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 6:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 7:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 8:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 9:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 10:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		case 11:
			for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
				int damage = (int)(bs.bp.em.logScaleDamage(perp, s) * 0.75);
				bs.bp.em.hpChange(damage, perp, s,6);
			}
			break;
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			int damage = (int)(bs.bp.em.logScaleDamage(perp, s)*(1.5+perp.getCritMulti()-s.getCritRes()) * 0.75);
			bs.bp.em.hpChange(damage, perp, s,6);
		}		
	}
	
}
