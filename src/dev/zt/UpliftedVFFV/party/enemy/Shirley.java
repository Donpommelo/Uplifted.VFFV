package dev.zt.UpliftedVFFV.party.enemy;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Shirley extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	public final static int startHp=17,startBp=25,startPow=15, startDef=9, startSpd=20, startSkl=8, startLuk=7, startInt=6;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=1.2, bpGrowth=.7, powGrowth=5.7, defGrowth=1.3, spdGrowth=2.9, sklGrowth=1.6, intGrowth=1.2, lukGrowth=.5;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=19;
	public final static int scrDrop=1;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Shirley";
	public static String plural = "Shirlies";
	public static String pronoun = "her";
	
	public static int sprite = 14;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {};
	public static int[] levelReqs = {};
	
	public final static Item[] itemDrops = {};
	public final static double[] dropRates = {};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public Shirley(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths, baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	public Action getAction(BattleState bs){
		if(!bs.bs.alliesTargets.isEmpty()){
			return new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
		}
		else{
			return new Action(this,this,new PassTurn(0),bs);
		}	
	}
}
