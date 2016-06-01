package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.MultipleProjAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.IntrusiveThoughtEffect;

public class SpreadingDoubt extends Skills {

	public static String name = "Spreading Doubt";
	public static String descr = "TEMP";
	public static String descrShort = "Delayed damage debuff.";
	public static int cost = 2;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 4;	//Purple
	public static int targetType = 1;	//No Target
	public static BattleAnimation[] ba = {new MultipleProjAnim(4)};

	public SpreadingDoubt(int index) {
		super(index, targetType, element, name, descr, descrShort, cost,1, baseAcc, baseCrit, canMiss, canCrit,ba);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(Schmuck s : bs.bp.getSelectableEnemies(perp)){
			bs.bp.em.hpChange(-(3), perp, s,4);
			bs.bp.stm.addStatus(s, new IntrusiveThoughtEffect(perp, s, 50));	
		}
		
	}
	
}
