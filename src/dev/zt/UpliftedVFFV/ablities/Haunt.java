package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.TestStatBuff;

public class Haunt extends Skills {

	public static String name = "Haunt";
	public static String descr = "User returns from the grave\nto damage and unnerve foes.";
	public static String descrShort = "Damages and debuffs all enemies.";
	public static int cost = 0;
	public Haunt(int index) {
		super(index,1,6, name, descr, descrShort, cost);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Haunt!");
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(perp.buffedStats[2]*perp.buffedStats[2]*2)/(s.buffedStats[3]*10), perp, s);
			bs.bp.stm.addStatus(s, new TestStatBuff(5,3,.9,perp,80));
		}

	}
		
	public int getTargetType(){
		return targetType;
	}
}
