package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.OpeningCircleTargetAnim;
import dev.zt.UpliftedVFFV.Battle.Animations.UserBobAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.DespawnonDeath;


public class ThinkDirty extends Skills {

	public static String name = "Think Dirty";
	public static String descr = "User summons a temporary ally to aid in battle.";
	public static String descrShort = "Summons a Rotthought.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 4;	//Purple
	public static int targetType = 1;	//No Target
	public static BattleAnimation[] ba = {new UserBobAnim(),new UserBobAnim()};
	public ThinkDirty(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, 1,baseAcc, baseCrit, canMiss, canCrit,ba);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck summon = new RotThought(1);
		bs.bp.bt.addScene("A Rotthought coalesced!");
		if(bs.bp.allies.contains(perp)){
			bs.bp.allies.add(summon);
		}
		else{
			bs.bp.enemy.add(summon);
		}
		bs.bp.stm.addStatus(summon, new DespawnonDeath(summon,50));
		bs.bs.locationUpdate();
		bs.bs.targetUpdate();
	}
	
	public String useName(Schmuck perp, Schmuck vic, BattleState bs){
		return 	perp.getName()+" is giving it some thought!";
	}


}
