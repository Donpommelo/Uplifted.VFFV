package dev.zt.UpliftedVFFV.party.enemy;

import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Coalesce;
import dev.zt.UpliftedVFFV.ablities.Ennervate;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.MentalLeakage;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RotThought extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=50,startPow=42, startDef=51, startSpd=35, startSkl=29, startLuk=47, startInt=51;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=33.6, bpGrowth=24.7, powGrowth=3.7, defGrowth=4.7, spdGrowth=1.8, sklGrowth=2.9, intGrowth=3.1, lukGrowth=1.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=2;
	public final static int scrDrop=4;
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 10, basePurple = 20, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};

	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Rotthought";
	public static String plural = "Rotthoughts";
	public static String pronoun = "it";
	
	public static int sprite = 4;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new Ennervate(0), new Coalesce(0)};
	public static int[] levelReqs = {0,3};
	
	public final static Item[] itemDrops = {new MentalLeakage()};
	public final static double[] dropRates = {.75};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "A weakly malicious intention. Floats feebly through the cubicles where it was born.";
	public final static String bioLong = "";
	
	public RotThought(int level) {
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
