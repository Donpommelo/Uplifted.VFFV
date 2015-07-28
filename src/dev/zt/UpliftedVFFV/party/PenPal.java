package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;

import dev.zt.UpliftedVFFV.ablities.ArcherRoulette;
import dev.zt.UpliftedVFFV.ablities.BoxCutter;
import dev.zt.UpliftedVFFV.ablities.Censor;
import dev.zt.UpliftedVFFV.ablities.DoubleGeneva;
import dev.zt.UpliftedVFFV.ablities.ForceWithin;
import dev.zt.UpliftedVFFV.ablities.HeresHow;
import dev.zt.UpliftedVFFV.ablities.InvertedSwan;
import dev.zt.UpliftedVFFV.ablities.PennyBlack;
import dev.zt.UpliftedVFFV.ablities.Query;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.TreskillingYellow;
import dev.zt.UpliftedVFFV.ablities.TyrianPlum;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.ablities.PennyBlue;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PenPal extends Schmuck{

	private static final long serialVersionUID = -7556561902401868149L;
	
	//	public final static int startHp=42,startBp=40,startPow=15, startDef=17, startSpd=12, startSkl=22, startLuk=25, startInt=16;
	public final static int[] startStats = {53, 38, 15, 17, 12, 22, 25, 16};
//	public final static double hpGrowth=1, bpGrowth=2.3, powGrowth=1.4, defGrowth=1.3, spdGrowth=2, sklGrowth=2.1, intGrowth=2.6, lukGrowth=1.3;
	public final static double[] statGrowths = {1, 1.5, 1.4, 1.3, 2, 2.1, 2.6, 1.3};
// static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {10,20,20,10,10,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public static int Lvl=1;
	public int exp=0;
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public PenPal() {
		super("Pen Pal",1,ImageLoader.loadImage("/BattleSprites/PenPal.png"),ImageLoader.loadImage("/CharacterBusts/Player-5.png"), startStats, statGrowths, elemRes);
		calcStats(1);
		this.bio = "Your very own foreign correspondence. Looks leafy.";
//		this.levelSkills = new TreeMap<Integer, Skills>();
//		this.levelSkills.put(2, new PennyBlue(0));
//		this.levelSkills.put(3, new TreskillingYellow(0));
//		this.levelSkills.put(5, new TyrianPlum(0));
//		this.levelSkills.put(8, new HeresHow(0));
//		this.levelSkills.put(10, new ArcherRoulette(0));
//		this.levelSkills.put(12, new InvertedSwan(0));
//		this.levelSkills.put(15, new DoubleGeneva(0));
//		this.levelSkills.put(21, new PennyBlack(0));
		super.learnSkill(new BoxCutter(0));
		super.learnSkill(new Query(0));
		super.learnSkill(new PennyBlue(0));
		super.learnSkill(new TreskillingYellow(0));
		super.learnSkill(new TyrianPlum(0));
		super.learnSkill(new ArcherRoulette(0));
		super.learnSkill(new InvertedSwan(0));
		super.learnSkill(new HeresHow(0));
		super.learnSkill(new DoubleGeneva(0));
		super.learnSkill(new PennyBlack(0));
		
		super.learnSkill(new Censor(0));
		super.learnSkill(new ForceWithin(0));


		

		
		


	}
	

}
