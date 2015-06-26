package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;






import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BadEgg extends Schmuck{

	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {17,25,15,9,20,8,7,6};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {1.2 , .7 , 5.7 , 1.3 , 2.9 , 1,6 , 1.2 , .5};
	public final static int expDrop=19;
	public final static int scrDrop=1;
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public final static double[] elemRes = {.1,.1,.1,.1,.1,0};
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public BadEgg(int lvl) {
//		super("Jorge",100,50, 12, 20, 17, 8, 10, 5,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"));
		super("Bad Egg",lvl,ImageLoader.loadImage("/BattleSprites/Bad Egg.png"), startStats, statGrowths,elemRes);
		calcStats(lvl);
		this.bio = "The uncouth spirit of an unborn chicken.";
	}
	
	
	
	public Action getAction(BattleState bs){
		
		return new Action(this,bs.bs.alliesTargets.get((int)(Math.random()*bs.bs.alliesTargets.size())),new StandardAttack(0),bs);
		
	}
	
	public int getExpDrop() {
		return expDrop;
	}

	public int getScrDrop() {
		return scrDrop;
	}

}
