package dev.zt.UpliftedVFFV.ablities;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class DayattheFair extends Skills {

	public static String name = "Day at the Fair";
	public static String descr = "User summons a chaotic parade\nthat disturbs the fight and\nends the round.";
	public static String descrShort = "Damages and ends round\nprematurely.";
	public static int cost = 21;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = true;
	public DayattheFair(int index) {
		super(index,1,6, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" uses Day at the Fair");
		bs.bp.bt.textList.add("The round was ended prematurely");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(s.buffedStats[3]*2), perp, s,6);
		}
		bs.bp.TurnOrderQueue.clear();
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Day at the Fair");
		bs.bp.bt.textList.add("A Critical blow!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1+perp.getCritMulti())), perp, s,6);
		}
	}
		
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = 0;
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			damage += bs.bp.em.damageSimulation(-(perp.buffedStats[2]*perp.buffedStats[2])/(s.buffedStats[3]*2),perp,s,6,1000);
		}
		return damage;
	}
	
}
