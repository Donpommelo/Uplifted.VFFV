package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
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
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {50,5,10,5,10,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public static String name = "Coffee Elemental";
	public static String plural = "Coffee Elementals";
	public static String pronoun = "it";
	public CoffeeElem(int lvl) {
		super(name, pronoun,  plural, lvl, 7, startStats, statGrowths, elemRes, expDrop, scrDrop);
		calcStats(lvl);
		this.bio = "A  dangerously hot elemental. Maintains and enforces orderly conduct in the Offices.";
		itemdrops.put(new CoffeeBean(), 1.0);
		itemdrops.put(new BossMug(), .1);
	}
	
	
	public Action getAction(BattleState bs){
		if(!bs.bs.alliesTargets.isEmpty()){
			return new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new Scald(0),bs);
		}
		else{
			return new Action(this,this,new PassTurn(0),bs);

		}
	}
	
	
	public TreeMap<Item, Double> getItemdrops() {
		return itemdrops;
	}

	public void setItemdrops(TreeMap<Item, Double> itemdrops) {
		this.itemdrops = itemdrops;
	}
}
