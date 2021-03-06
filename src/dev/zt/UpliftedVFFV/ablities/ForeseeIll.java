package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.IntrusiveThoughtEffect;

public class ForeseeIll extends Skills {

	public static String name = "Foresee Ill";
	public static String descr = "User brings bad tidings to a targeted foe, dealing heavy damage that scales with the target's Intrusive Thoughts.";
	public static String descrShort = "Release built up Intrusive Thoughts.";
	public static int cost = 4;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 4;	//Purple
	public static int targetType = 0;	//Any Single Target
	public ForeseeIll(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		if(bs.bp.stm.checkStatus(vic, new IntrusiveThoughtEffect(perp,vic,50))){
			bs.bp.em.hpChange(-(int)Math.pow(2, bs.bp.stm.findStatus(vic, new IntrusiveThoughtEffect(perp,vic,50)).getExtraVar1()+2), perp, vic,4);
			bs.bp.stm.removeStatus(vic, new IntrusiveThoughtEffect(perp,vic,50));
		}
		else{
			bs.bp.bt.addScene("But it failed.");
		}
	}

}
