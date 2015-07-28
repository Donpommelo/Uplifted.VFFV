package dev.zt.UpliftedVFFV.ablities;


import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Ablaze;


public class Scald extends Skills {

	public static String name = "Scald";
	public static String descr = "A spray of boiling hot liquid that\ncan inflict nasty burns.";
	public static String descrShort = "Red damage and Ablaze.";
	public static int cost = 5;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public Scald(int index) {
		super(index,0,0, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Scald!");
		bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*1.2), perp,vic,0);
		bs.bp.stm.addStatus(vic, new Ablaze(3, perp, 70));	
	}

	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" uses Scald!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange((int)(-(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3])), perp,vic,0);
		bs.bp.stm.addStatus(vic, new Ablaze((int)(3*(1.5+perp.getCritMulti())), perp, 70));
	}
	

	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int damage = -(int)(perp.buffedStats[2]*perp.buffedStats[2])/(int)(vic.buffedStats[3]*1.2);
		return bs.bp.em.damageSimulation(damage, perp, vic, 0,100);
	}
}
