package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;

import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.PassTurn;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class Midgeon extends Schmuck{

	private static final long serialVersionUID = -7556561902401868149L;
	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {12,22,8,6,22,11,13,4};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {1.5 , 1.1 , 1.7 , 1 , 2.9 ,1.6 , 1.2 , 1.2};
	public final static int expDrop=19;
	public final static int scrDrop=1;
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static int[] elemRes = {10,10,10,10,10,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public static String name = "Midgeon";
	public static String plural = "Midgeons";
	public static String pronoun = "it";
	public Midgeon(int lvl) {
		super(name,plural,pronoun,lvl,ImageLoader.loadImage("/BattleSprites/Midgeon.png"), startStats, statGrowths,elemRes, expDrop, scrDrop);
		calcStats(lvl);
		this.bio = "TEST.";
	}
	
	
	
	public Action getAction(BattleState bs){
		if(!bs.bs.alliesTargets.isEmpty()){
			return new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
		}
		else{
			return new Action(this,this,new PassTurn(0),bs);

		}
		
	}


}
