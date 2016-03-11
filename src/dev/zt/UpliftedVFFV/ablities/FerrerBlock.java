package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Frozen;
import dev.zt.UpliftedVFFV.statusEffects.Poisoned;
import dev.zt.UpliftedVFFV.statusEffects.Stats.BonusStatBuff;

public class FerrerBlock extends Skills {

	public static String name = "Ferrer Block";
	public static String descr = "User encases target in a block of healing ice that soothes wounds but prevents activity.";
	public static String descrShort = "Freeze target and boost Hp regen.";
	public static int cost = 32;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 2;	//Blue
	public static int targetType = 0;	//Any Single Target
	public FerrerBlock(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.stm.addStatus(vic, new BonusStatBuff(2,34,vic.getMaxHp()/5 * (1+perp.getHealPower()),perp,50));
		bs.bp.stm.addStatus(vic, new Frozen(2, perp, 40));
	}

}
