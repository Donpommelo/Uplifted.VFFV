package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.StandardAttackAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.EquipmentStatus.BandagedSwordStatus;

public class StandardAttack extends Skills {

	public static String name = "Attack";
	public static String descr = "User attacks a foe.";
	public static String descrShort = "Deals damage target.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public static int maxFrames = 30;
	public static BattleAnimation ba = new StandardAttackAnim();
	public StandardAttack(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 0, baseAcc, baseCrit, canMiss, canCrit, ba);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		int statAttack = (int)(perp.getDamageStat()+2);
		if((int)perp.getElemAlignment() == 0 ){
			bs.bp.em.hpChange(-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], perp, vic,6);
			}
		else{
			bs.bp.em.hpChange(-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], perp, vic,(int)(perp.getElemAlignment()-1));				
		}
		perp.onStandardAttackEffects(vic, -(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], bs);
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		int statAttack = (int)(perp.getDamageStat()+2);
		bs.bp.em.hpChange((int)(damageCalc(perp,vic,bs)*(1.5+perp.getCritMulti()-vic.getCritRes())), perp, vic,6);
		perp.onStandardAttackEffects(vic, -(int)((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3]*(1.5+perp.getCritMulti()-vic.getCritRes())), bs);

	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int statAttack = (int)(perp.getDamageStat()+2);
		int damage = -(int)((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/(vic.buffedStats[3]));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
	
	public void TOQChange(Action a, BattleState bs){
		if(bs.bp.stm.checkStatus(a.user, new BandagedSwordStatus(50))){
			bs.bp.TurnOrderQueue.remove(a);
			bs.bp.TurnOrderQueue.add(0, a);
		}
	}
		
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return 	perp.getName()+" attacks "+vic.getName()+"!";
	}
		
}
