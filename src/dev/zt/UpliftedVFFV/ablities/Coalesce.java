package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.Stats.TestStatBuff;

public class Coalesce extends Skills {

	public static String name = "Coalesce";
	public static String descr = "User focuses own being/buffing random stats./";
	public static String descrShort = "Buffs two random stats./";
	public static int cost = 6;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = true; public static boolean canCrit = true;
	public static int element = 6;	//Physical
	public static int targetType = 0;	//Any Single Target
	public Coalesce(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);

	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		for(int i = 0; i < 2; i++){
			int random = (int)(Math.random()*6);
			switch(random){
			case 0:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,2,1.1, perp,50));
				break;
			case 1:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,3,1.1, perp,50));
				break;
			case 2:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,4,1.1, perp,50));
				break;
			case 3:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,5,1.1, perp,50));
				break;
			case 4:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,6,1.1, perp,50));
				break;
			case 5:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,7,1.1, perp,50));
				break;
			}
		}
	}
	
	public void runCrit(Schmuck perp, Schmuck vic, BattleState bs){
		for(int i = 0; i < 5*(1+(perp.getCritMulti()-vic.getCritRes())); i++){
			int random = (int)(Math.random()*6);
			switch(random){
			case 0:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,2,1.1, perp,50));
				break;
			case 1:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,3,1.1, perp,50));
				break;
			case 2:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,4,1.1, perp,50));
				break;
			case 3:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,5,1.1, perp,50));
				break;
			case 4:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,6,1.1, perp,50));
				break;
			case 5:
				bs.bp.stm.addStatus(perp, new TestStatBuff(4,7,1.1, perp,50));
				break;
			}
		}		
	}
}
