package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Ennervate;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.consummables.MentalLeakage;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class RotThoughtTutorial extends Schmuck{

//	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {19,27,9,18,5,9,7,11};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {3.6 , 4.7 , 5.7 , 4.7 , .8 , 1.9 , 3.1 , .9};
	public final static int expDrop=4;
	public final static int scrDrop=4;
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {10,10,10,10,10,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses = new ArrayList<status>(1);
	public static String name = "Rotthought";
	public static String plural = "Rotthoughts";
	public static String pronoun = "it";
	public RotThoughtTutorial(int lvl) {
		super(name, plural, pronoun, lvl, 4, startStats, statGrowths, elemRes, expDrop, scrDrop);
		calcStats(lvl);
		this.bio = "A weakly malicious intention. Floats feebly thought the cubicles where it was born.";
		itemdrops.put(new MentalLeakage(), 1.0);
	}
	
	
	public Action getAction(BattleState bs){
		System.out.print(this.statuses);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
		switch(bs.bp.roundNum){
		case 0:
			
			act = new Action(this,bs.bs.alliesTargets.get(0),new StandardAttack(0),bs);
		case 1:
			
			act = new Action(this,bs.bs.alliesTargets.get(0),new Ennervate(0),bs);
		case 2:
			
			act = new Action(this,bs.bs.alliesTargets.get(0),new StandardAttack(0),bs);
		}
		
		return act;

		
		
					
	}
	
	public TreeMap<Item, Double> getItemdrops() {
		return itemdrops;
	}

	public void setItemdrops(TreeMap<Item, Double> itemdrops) {
		this.itemdrops = itemdrops;
	}
	

}