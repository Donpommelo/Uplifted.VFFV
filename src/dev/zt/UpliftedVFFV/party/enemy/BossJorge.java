package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;






import java.util.TreeMap;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.CrushingSlam;
import dev.zt.UpliftedVFFV.ablities.FlexileStrike;
import dev.zt.UpliftedVFFV.ablities.PantherPoise;
import dev.zt.UpliftedVFFV.ablities.Pounce;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.inventory.BossMug;
import dev.zt.UpliftedVFFV.inventory.CoffeeBean;
import dev.zt.UpliftedVFFV.inventory.Item;
import dev.zt.UpliftedVFFV.inventory.LetterOpener;
import dev.zt.UpliftedVFFV.inventory.PostageStamp;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BossJorge extends Schmuck{

	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {110,100,15,20,16,16,10,5};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {1 , .7 , 1.2 , 1.3 , 1.7 , 1.5 , 1.9 , .9};
	public final static int expDrop=100;
	public final static int scrDrop=25;
	public TreeMap<Item, Double> itemdrops = new TreeMap<>();
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static double[] elemRes = {.1,.1,.1,.1,.1,0};
//	public int x = 400;
//	public int y = 0;
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public BossJorge(int lvl) {
//		super("Jorge",100,50, 12, 20, 17, 8, 10, 5,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"));
		super("Jorge",lvl,ImageLoader.loadImage("/BattleSprites/Jorge.png"), startStats, statGrowths, elemRes);
		calcStats(lvl);
		this.bio = "Unhelpful middle manager. Foul-tempered and steals food from coworkers.";
		itemdrops.put(new PostageStamp(), 1.0);
		itemdrops.put(new PostageStamp(), 1.0);
		itemdrops.put(new PostageStamp(), 1.0);
		itemdrops.put(new LetterOpener(), 1.0);
		
	}
	
	
	public Action getAction(BattleState bs){
		int random = (int)(Math.random()*4);
		Action act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);;
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
				act = new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new CrushingSlam(0),bs);
				break;
		}
		return act;
		
	}
	
	public int getExpDrop() {
		return expDrop;
	}

	public int getScrDrop() {
		return scrDrop;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public TreeMap<Item, Double> getItemdrops() {
		return itemdrops;
	}

	public void setItemdrops(TreeMap<Item, Double> itemdrops) {
		this.itemdrops = itemdrops;
	}

}
