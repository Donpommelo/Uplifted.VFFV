package dev.zt.UpliftedVFFV.party.enemy;


import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.BlindingStrike;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.SeeingEye;
import dev.zt.UpliftedVFFV.inventory.equipables.CatchersGlove;
import dev.zt.UpliftedVFFV.inventory.equipables.CatchersMask;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class EyeCatcher extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=60,startBp=50,startPow=11, startDef=12, startSpd=28, startSkl=29, startLuk=3, startInt=11;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=2.3, bpGrowth=1.7, powGrowth=2.7, defGrowth=.9, spdGrowth=3.7, sklGrowth=1.9, intGrowth=.1, lukGrowth=.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=10;
	public final static int scrDrop=15;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Eye Catcher";
	public static String plural = "Eye Catchers";
	public static String pronoun = "it";
	
	public static int sprite = 8;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new BlindingStrike(0)};
	public static int[] levelReqs = {0};
	
	public final static Item[] itemDrops = {new SeeingEye(), new CatchersGlove(), new CatchersMask()};
	public final static double[] dropRates = {1.0, .15, .1};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "Dangerous monster that steals the eyes from its victims. Probably has a collection or something.";
	public final static String bioLong = "";
	
	public EyeCatcher(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*2);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		if(bs.bs.alliesTargets.isEmpty()){
			return new Action(this,this,new PassTurn(0),bs);
		}
		else{
			switch (random){
			case 0:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new BlindingStrike(0),bs);
				break;
			}
		}	
		return act;
	}
}
