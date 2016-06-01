package dev.zt.UpliftedVFFV.party.enemy;


import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.GenerateHeat;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Scald;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consumables.CoffeeBean;
import dev.zt.UpliftedVFFV.inventory.equipables.BossMug;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CoffeeElem extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=60,startPow=49, startDef=48, startSpd=63, startSkl=38, startLuk=20, startInt=35;
	public final static int[] startStats = {startHp,startBp,startPow,startDef,startSpd,startSkl,startInt,startLuk};
	public final static double hpGrowth=40.0, bpGrowth=40.0, powGrowth =5.0, defGrowth=5.0, spdGrowth=5.0, sklGrowth=5.0, intGrowth=5.0, lukGrowth=5.0;
	public final static double[] statGrowths = {2 , 2.7 , 2.2 , 2.3 , 1.7 , 1.5 , .8 , .9};
	public final static int expDrop=10;
	public final static int scrDrop=9;
	public final static int baseRed = 50, baseBlue = 5, baseGreen = 10, baseYellow = 5, basePurple = 10, baseVoid = 0;
	public final static int[] baseElem = {baseRed, baseBlue, baseGreen, baseYellow, basePurple, baseVoid};
		
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();

	public static String name = "Coffee Elemental";
	public static String plural = "Coffee Elementals";
	public static String pronoun = "it";
	
	public static int sprite = 7;
	public static int menusprite = 0;
	
	public static Skills[] levelSkills = {new Scald(0), new GenerateHeat(0)};
	public static int[] levelReqs = {0,0};
	
	public final static Item[] itemDrops = {new CoffeeBean(), new BossMug()};
	public final static double[] dropRates = {1.0, .5};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "A  dangerously hot elemental. Maintains and enforces orderly conduct in the Offices.";
	public final static String bioLong = "";
	
	public CoffeeElem(int level) {
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
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Scald(0),bs);
				break;
			case 2:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new GenerateHeat(0),bs);
				break;
			}
		}	
		return act;
	}
	
	
}
