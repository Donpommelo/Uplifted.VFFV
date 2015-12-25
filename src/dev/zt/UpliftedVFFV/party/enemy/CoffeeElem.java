package dev.zt.UpliftedVFFV.party.enemy;


import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.GenerateHeat;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Scald;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consummables.CoffeeBean;
import dev.zt.UpliftedVFFV.inventory.equipables.BossMug;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class CoffeeElem extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {70,29,15,21,24,12,8,6};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
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
	public final static double[] dropRates = {1.0, .1};
	public final static status[] intrinsicStatuses = {};
	
	public final static String bioShort = "A  dangerously hot elemental. Maintains and enforces orderly conduct in the Offices.";
	public final static String bioLong = "";
	
	public CoffeeElem(int level) {
		super(name, plural, pronoun, level, sprite, menusprite, startStats, statGrowths,baseElem, expDrop, scrDrop, levelSkills,
				levelReqs, itemDrops, dropRates, intrinsicStatuses, bioShort, bioLong);
	}
	
	
	public Action getAction(BattleState bs){
		if(!bs.bs.alliesTargets.isEmpty()){
			return new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Scald(0),bs);
		}
		else{
			return new Action(this,this,new PassTurn(0),bs);

		}
	}
	
}
