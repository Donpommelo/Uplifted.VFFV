package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.MotorGrinder;
import dev.zt.UpliftedVFFV.ablities.Pounce;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Operator extends Schmuck{
	
//	public final static int startHp=50,startBp=35,startPow=17, startDef=18, startSpd=17, startSkl=13, startLuk=12, startInt=18;
	public final static int[] startStats = {50,35,17,18,17,13,18,12};
//	public final static double hpGrowth=1, bpGrowth=.7, powGrowth=1.2, defGrowth=1.3, spdGrowth=1.7, sklGrowth=1.5, intGrowth=1.9, lukGrowth=.9;
	public final static double[] statGrowths = {1 , .7 , 1.2 , 1.3 , 1.7 , 1.5 , 1.9 , .9};
//	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public static int Lvl=1;
	public int exp=0;
	public ArrayList<Skills> skills;
	public TreeMap<Integer, Skills> levelSkills = new TreeMap<>();
	public ArrayList<status> statuses;
	public Operator() {
		super("Operator",1,ImageLoader.loadImage("/BattleSprites/Operator.png"), startStats, statGrowths);
		super.calcStats(1);
		this.skills = new ArrayList<Skills>(1);
		this.levelSkills = new TreeMap<Integer, Skills>();
		this.levelSkills.put(2, new MotorGrinder(0));
		super.learnSkill(new DoorsofClosure(0));
		super.learnSkill(new MotorGrinder(0));


	}
	
	public TreeMap<Integer, Skills> getLevelSkills() {
		return levelSkills;
	}
	public void setLevelSkills(TreeMap<Integer, Skills> levelSkills) {
		this.levelSkills = levelSkills;
	}


}
