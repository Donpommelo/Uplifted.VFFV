package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.gfx.Assets;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;

public class InvertedSwanBonusAttack extends Skills {

	
	public static String name = "Extra Attack";
	public static String descr = "User attacks a foe.";
	public static String descrShort = "Deals damage target.";
	public static int cost = 0;
	public InvertedSwanBonusAttack(int index) {
		super(index, 0, 6, name, descr, descrShort, cost, Assets.attack);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+" again!");
		if(bs.bp.em.getAcc(perp, vic,100)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3], perp, vic,1);
		}		
		else{
			bs.bp.bt.textList.add(perp.getName()+" missed!");
		}		
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		bs.bp.bt.textList.add(perp.getName()+" attacks "+vic.getName()+" again!");
		bs.bp.bt.textList.add("A Critical blow!");
		bs.bp.em.hpChange(-(int)(((perp.buffedStats[2]*perp.buffedStats[2])/vic.buffedStats[3])*(1.5+perp.getCritMulti())), perp, vic,1);		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		int statAttack = (int)(perp.getDamageStat()+2);
		int damage = -(int)((perp.buffedStats[statAttack]*perp.buffedStats[statAttack])/(vic.buffedStats[3]));
		return bs.bp.em.damageSimulation(damage, perp, vic, 6,100);
	}
}
