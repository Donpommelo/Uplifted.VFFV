package dev.zt.UpliftedVFFV.party.enemy;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Coalesce;
import dev.zt.UpliftedVFFV.ablities.Ennervate;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class WanderingMind extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=19,startBp=27,startPow=9, startDef=18, startSpd=5, startSkl=9, startLuk=7, startInt=11;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=3.6, bpGrowth=4.7, powGrowth=5.7, defGrowth=4.7, spdGrowth=.8, sklGrowth=1.9, intGrowth=3.1, lukGrowth=.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=2;
	public final static int scrDrop=4;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 20, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Wandering Mind";
	public static String plural = "Wandering Minds";
	public static String pronoun = "it";
	
	public static int sprite = 14;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {};
	public static int[] levelReqs = {};
	
	public final static Item[] itemDrops = {};
	public final static double[] dropRates = {};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "TEMP";
	public final static String bioLong = "";
	
	public WanderingMind(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths, baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*3);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			return new Action(this,this,new PassTurn(0),bs);
		}
		else{
			switch (random){
			case 0:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Ennervate(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Coalesce(0),bs);
				break;
			}
		}	
		return act;
	}
}
