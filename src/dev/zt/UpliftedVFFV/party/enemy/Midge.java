package dev.zt.UpliftedVFFV.party.enemy;

import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.LifeDrain;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.ablities.Swarm;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.MidgeBlood;
import dev.zt.UpliftedVFFV.inventory.equipables.MidgeProboscis;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Midge extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=12,startBp=22,startPow=8, startDef=6, startSpd=22, startSkl=11, startLuk=13, startInt=4;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=1, bpGrowth=.7, powGrowth=1.7, defGrowth=.6, spdGrowth=3.1, sklGrowth=1.4, intGrowth=1, lukGrowth=.9;
	public final static double[] statGrowths = {hpGrowth , bpGrowth , powGrowth , defGrowth, spdGrowth , sklGrowth , intGrowth , lukGrowth};
	public final static int expDrop=1;
	public final static int scrDrop=1;
	
	public final static int baseRed = 10, baseBlue = 10, baseGreen = 10, baseYellow = 20, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
	
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Midge";
	public static String plural = "Midges";
	public static String pronoun = "it";
	
	public static int sprite = 2;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new LifeDrain(0), new Swarm(0)};
	public static int[] levelReqs = {0,0};
	
	public final static Item[] itemDrops = {new MidgeBlood(), new MidgeProboscis()};
	public final static double[] dropRates = {.3, .1};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "A small bloodsucking insect. The swelling caused by their bites are actually egg sacs.";
	public final static String bioLong = "";
	
	public Midge(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs,itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
		itemdrops.put(new MidgeBlood(), .3);
		itemdrops.put(new MidgeProboscis(), .1);
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
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new LifeDrain(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Swarm(0),bs);
				break;
			}
		}	
		return act;
	}
}
