package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.Battle.BattleAnimation;
import dev.zt.UpliftedVFFV.Battle.Animations.OpeningCircleTargetAnim;
import dev.zt.UpliftedVFFV.Battle.Animations.UserBobAnim;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.DespawnonDeath;


public class Transform extends Skills {

	public static String name = "Transform";
	public static String descr = "User transforms into a different character.";
	public static String descrShort = "Transform?";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public static BattleAnimation[] ba = {new UserBobAnim(),new UserBobAnim()};
	public Schmuck newschmuck;
	public Transform(int index, Schmuck newSchmuck) {
		super(index, targetType, element, name, descr, descrShort, cost, 1,baseAcc, baseCrit, canMiss, canCrit,ba);
		this.newschmuck = newSchmuck;
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck summon = newschmuck;
		bs.bp.bt.addScene(perp.getName()+" is transforming into "+summon.getName()+"!");
		int index = bs.bp.enemy.indexOf(perp);
		bs.bp.enemy.remove(perp);
		if(bs.bp.allies.contains(perp)){
			bs.bp.allies.add(index,summon);
		}
		else{
			bs.bp.enemy.add(index,summon);
		}
		bs.bs.locationUpdate();
		bs.bs.targetUpdate();
	}

}
