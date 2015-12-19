package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.skillSpecific.IntrusiveThoughtEffect;

public class IntrusiveThought extends Skills {

	public static String name = "Intrusive Thought";
	public static String descr = "User causes a target's Intrusive\nThoughts to flourish,\nstacking an invisible debuff.";
	public static String descrShort = "Delayed damage debuff.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = false;
	public static int element = 4;	//Purple
	public static int targetType = 0;	//Any Single Target
	public IntrusiveThought(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		bs.bp.bt.textList.add(perp.getName()+" used Intrusive Thought!");
		bs.bp.em.hpChange(-(3), perp, vic,6);
		if(bs.bp.stm.checkStatus(vic, new IntrusiveThoughtEffect(perp, 50))){
			bs.bp.stm.findStatus(vic, new IntrusiveThoughtEffect(perp, 50)).stack++;
			bs.bp.bt.textList.add(vic.getName()+"'s Intrusive Thoughts grow.");
		}
		else{
			bs.bp.stm.addStatus(vic, new IntrusiveThoughtEffect(perp, 50));
		}		
	}
	
	public int damageCalc(Schmuck perp, Schmuck vic, BattleState bs){
		return 3;
	}
}
