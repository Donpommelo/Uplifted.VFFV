package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.LifeDrain;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.MidgeBlood;
import dev.zt.UpliftedVFFV.inventory.MidgeProboscis;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Midge extends Schmuck{

	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {12,22,8,6,22,11,13,4};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {1 , .7 , 1.7 , .6 , 3.1 , 1.4 , 1 , .9};
	public final static int expDrop=2;
	public final static int scrDrop=1;
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {10,10,10,10,10,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public Midge(int lvl) {
//		super("Jorge",100,50, 12, 20, 17, 8, 10, 5,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"));
		super("Midge",lvl,ImageLoader.loadImage("/BattleSprites/Midge.png"), startStats, statGrowths, elemRes, expDrop, scrDrop);
		calcStats(lvl);
		this.bio = "A small bloodsucking insect. The swelling caused by their bites are actually egg sacs.";
		itemdrops.put(new MidgeBlood(), .3);
		itemdrops.put(new MidgeProboscis(), .1);
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
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new LifeDrain(0),bs);
				break;
			case 1:
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
				break;
			}
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
