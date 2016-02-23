package dev.zt.UpliftedVFFV.party.enemy;


import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.CrushingSlam;
import dev.zt.UpliftedVFFV.ablities.FlexileStrike;
import dev.zt.UpliftedVFFV.ablities.PantherPoise;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.ablities.WindUpPunch;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.equipables.LetterOpener;
import dev.zt.UpliftedVFFV.inventory.misc.PostageStamp;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BossJorge extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=300,startBp=160,startPow=49, startDef=59, startSpd=29, startSkl=53, startLuk=20, startInt=37;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=70, bpGrowth=22.7, powGrowth=3.2, defGrowth=6.3, spdGrowth=7.7, sklGrowth=12.5, intGrowth=3.9, lukGrowth=5.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=50;
	public final static int scrDrop=25;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Jorge";
	public static String plural = "Jorge";
	public static String pronoun = "he";

	public static int sprite = 9;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new FlexileStrike(0), new WindUpPunch(0), new PantherPoise(0), new CrushingSlam(0)};
	public static int[] levelReqs = {0,0,1,3};
	
	public final static Item[] itemDrops = {new PostageStamp(), new PostageStamp(), new LetterOpener()};
	public final static double[] dropRates = {1.0, 1.0, 1.0};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "Unhelpful middle manager. Foul-tempered and steals food from coworkers.";
	public final static String bioLong = "";
	
	public BossJorge(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);		
	}
	
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*4);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			act = new Action(this,this,new FlexileStrike(0),bs);
		}
		else{
			switch (random){
			case 0:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new FlexileStrike(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 2:
				act = new Action(this,this,new PantherPoise(0),bs);
				break;
			case 3:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new WindUpPunch(0),bs);
				break;
			}
		}
		return act;
		
	}
	
}
