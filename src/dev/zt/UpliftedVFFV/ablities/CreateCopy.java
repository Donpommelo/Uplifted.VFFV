package dev.zt.UpliftedVFFV.ablities;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.party.enemy.BadEgg;
import dev.zt.UpliftedVFFV.party.enemy.IllRat;
import dev.zt.UpliftedVFFV.party.enemy.Lunk;
import dev.zt.UpliftedVFFV.party.enemy.Midge;
import dev.zt.UpliftedVFFV.party.enemy.RotThought;
import dev.zt.UpliftedVFFV.party.enemy.Shirley;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.DespawnonDeath;
import dev.zt.UpliftedVFFV.statusEffects.Silenced;


public class CreateCopy extends Skills {

	public static String name = "Create Copy";
	public static String descr = "User summons a temporary ally to aid in battle.";
	public static String descrShort = "Summons something.";
	public static int cost = 1;
	public static int baseAcc = 100; public static int baseCrit = 0;
	public static boolean canMiss = false; public static boolean canCrit = false;
	public static int element = 6;	//Physical
	public static int targetType = 1;	//No Target
	public CreateCopy(int index) {
		super(index, targetType, element, name, descr, descrShort, cost, baseAcc, baseCrit, canMiss, canCrit);
	}
	
	public void run(Schmuck perp, Schmuck vic, BattleState bs){	
		Schmuck summon = new Midge(1);
		switch((int)(Math.random()*6)){
		case 0:		
			summon = new Midge(1);
			break;
		case 1:		
			summon = new IllRat(1);
			break;
		case 2:		
			summon = new BadEgg(1);
			break;
		case 3:		
			summon = new Lunk(1);
			break;
		case 4:		
			summon = new RotThought(1);
			break;
		case 5:		
			summon = new Shirley(1);
			break;
		}
		bs.bp.bt.addScene(perp.getName()+" summoned a "+summon.getName()+"!");
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


}
