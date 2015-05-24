package dev.zt.UpliftedVFFV.party;


import java.util.ArrayList;

import dev.zt.UpliftedVFFV.ablities.BoxCutter;
import dev.zt.UpliftedVFFV.ablities.Ennervate;
import dev.zt.UpliftedVFFV.ablities.LifeDrain;
import dev.zt.UpliftedVFFV.ablities.Query;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.ablities.PennyBlue;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class PenPal extends Schmuck{

	
	
//	public final static int startHp=42,startBp=40,startPow=15, startDef=17, startSpd=12, startSkl=22, startLuk=25, startInt=16;
	public final static int[] startStats = {42, 40, 15, 17, 12, 22, 25, 16};
//	public final static double hpGrowth=1, bpGrowth=2.3, powGrowth=1.4, defGrowth=1.3, spdGrowth=2, sklGrowth=2.1, intGrowth=2.6, lukGrowth=1.3;
	public final static double[] statGrowths = {1, 2.3, 1.4, 1.3, 2, 2.1, 2.6, 1.3};
// static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static double[] elemRes = {.1,.2,.2,.1,.1,0};
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
		super.learnSkill(new BoxCutter(0));
		super.learnSkill(new Ennervate(0));
		super.learnSkill(new Query(0));
		super.learnSkill(new LifeDrain(0));
		super.learnSkill(new PennyBlue(0));

	}
	

}
