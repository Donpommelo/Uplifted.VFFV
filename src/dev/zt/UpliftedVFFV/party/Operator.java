package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;
import java.util.TreeMap;

import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.ablities.CentriDischarge;
import dev.zt.UpliftedVFFV.ablities.DamnedDescent;
import dev.zt.UpliftedVFFV.ablities.DayattheFair;
import dev.zt.UpliftedVFFV.ablities.DoorsofClosure;
import dev.zt.UpliftedVFFV.ablities.FiremansSwitch;
import dev.zt.UpliftedVFFV.ablities.MotorGrinder;
import dev.zt.UpliftedVFFV.ablities.SafeRoom;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.Terraform;
import dev.zt.UpliftedVFFV.ablities.VariableVoltage;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Operator extends Schmuck{
	
//	public final static int startHp=50,startBp=35,startPow=17, startDef=18, startSpd=17, startSkl=13, startLuk=12, startInt=18;
	public final static int[] startStats = {56,35,17,18,17,13,18,12};
//	public final static double hpGrowth=1, bpGrowth=.7, powGrowth=1.2, defGrowth=1.3, spdGrowth=1.7, sklGrowth=1.5, intGrowth=1.9, lukGrowth=.9;
	public final static double[] statGrowths = {1 , .7 , 1.2 , 1.3 , 1.7 , 1.5 , 1.9 , .9};
//	public final static double[] statGrowths = {10 , 10 , 10 , 10 , 10 , 10 , 10 , 10};
//	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
//	public static int[] baseStats=startStats;
//	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {20,10,10,20,10,0};
	public static int Lvl=1;
	public int exp=0;
	public ArrayList<Skills> skills;
	public TreeMap<Integer, Skills> levelSkills = new TreeMap<>();
	public ArrayList<status> statuses;
	public Operator() {
		super("Operator",1,ImageLoader.loadImage("/BattleSprites/Operator.png"),ImageLoader.loadImage("/CharacterBusts/Player-1.png"), startStats, statGrowths,elemRes);
		super.calcStats(1);
		this.bio = "The building's dependable and friendly elevator Operator.";
		this.skills = new ArrayList<Skills>(1);
//		this.levelSkills = new TreeMap<Integer, Skills>();
//		this.levelSkills.put(2, new SafeRoom(0));
//		this.levelSkills.put(3, new FiremansSwitch(0));
//		this.levelSkills.put(5, new VariableVoltage(0));
//		this.levelSkills.put(10, new DamnedDescent(0));
//		this.levelSkills.put(15, new CentriDischarge(0));
//		this.levelSkills.put(18, new Terraform(0));
//		this.levelSkills.put(21, new DayattheFair(0));
		super.learnSkill(new DoorsofClosure(0));
		super.learnSkill(new MotorGrinder(0));
		super.learnSkill(new SafeRoom(0));
		super.learnSkill(new FiremansSwitch(0));
		super.learnSkill(new VariableVoltage(0));
		super.learnSkill(new DamnedDescent(0));
		super.learnSkill(new CentriDischarge(0));
		super.learnSkill(new Terraform(0));
		super.learnSkill(new DayattheFair(0));

	}
	
	public TreeMap<Integer, Skills> getLevelSkills() {
		return levelSkills;
	}
	public void setLevelSkills(TreeMap<Integer, Skills> levelSkills) {
		this.levelSkills = levelSkills;
	}


}
