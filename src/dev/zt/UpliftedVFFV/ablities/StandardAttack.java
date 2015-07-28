package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class StandardAttack extends Skills {

	public static String name = "Attack";
	public static String descr = "User attacks a foe.";
	public static String descrShort = "Deals damage target.";
	public static int cost = 0;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public StandardAttack(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, Assets.attack, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		int statAttack = (int)(perp.getDamageStat()+2);
		if((int)perp.getElemAlignment() == 0 ){
			bs.bp.em.hpChange(-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], perp, vic,6);
			}
		else{
			bs.bp.em.hpChange(-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3], perp, vic,(int)(perp.getElemAlignment()-1));				
		}
		for(int i=0; i<perp.statuses.size(); i++){
			if(perp.statuses.get(i)!=null){
				perp.statuses.get(i).attackModify(perp, vic, bs,-(perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3]);
			}
		}	
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+"!");
		bs.bp.bt.textList.add("A Critical blow!");
		int statAttack = (int)(perp.getDamageStat()+2);
		bs.bp.em.hpChange((int)(damageCalc(perp,vic,bs)*(1.5+perp.getCritMulti())), perp, vic,6);
		for(int i=0; i<perp.statuses.size(); i++){
			if(perp.statuses.get(i)!=null){
				perp.statuses.get(i).attackModify(perp, vic, bs, -(int)((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/vic.buffedStats[3]*(1.5+perp.getCritMulti())));
			}
		}		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int statAttack = (int)(perp.getDamageStat()+2);
		int damage = -(int)((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/(vic.buffedStats[3]));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
		
}
