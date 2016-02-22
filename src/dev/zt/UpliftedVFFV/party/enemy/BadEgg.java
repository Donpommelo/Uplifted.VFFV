package dev.zt.UpliftedVFFV.party.enemy;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Poach;
import dev.zt.UpliftedVFFV.ablities.ScaryFace;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.equipables.BadShell;
import dev.zt.UpliftedVFFV.inventory.misc.BadYolk;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BadEgg extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=17,startBp=25,startPow=15, startDef=11, startSpd=20, startSkl=8, startLuk=7, startInt=6;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=1.2, bpGrowth=.7, powGrowth=3.2, defGrowth=1.3, spdGrowth=2.9, sklGrowth=1.6, intGrowth=1.2, lukGrowth=.5;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=4;
	public final static int scrDrop=1;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public static String name = "Bad Egg";
	public static String plural = "Bad Eggs";
	public static String pronoun = "it";
	
	public static int sprite = 6;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new Poach(0), new ScaryFace(0)};
	public static int[] levelReqs = {0,0};
	
	public final static Item[] itemDrops = {new BadYolk(), new BadShell()};
	public final static double[] dropRates = {.75, .25};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "The uncouth spirit of an unborn chicken.";
	public final static String bioLong = "";
	
	public BadEgg(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
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
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Poach(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new ScaryFace(0),bs);
				break;
			}
		}	
		return act;
	}
}
