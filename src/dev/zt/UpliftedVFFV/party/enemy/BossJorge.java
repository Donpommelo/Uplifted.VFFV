package dev.zt.UpliftedVFFV.party.enemy;


import java.util.ArrayList;






import dev.zt.UpliftedVFFV.Battle.Action;
import dev.zt.UpliftedVFFV.ablities.Skills;
import dev.zt.UpliftedVFFV.ablities.StandardAttack;
import dev.zt.UpliftedVFFV.gfx.ImageLoader;
import dev.zt.UpliftedVFFV.party.Schmuck;
import dev.zt.UpliftedVFFV.states.BattleState;
import dev.zt.UpliftedVFFV.statusEffects.status;

public class BossJorge extends Schmuck{

	
	public final static int startHp=100,startBp=50,startPow=12, startDef=20, startSpd=16, startSkl=8, startLuk=10, startInt=5;
	public final static int[] startStats = {100,50,12,20,16,8,10,5};
	public final static double hpGrowth=1, bpGrowth=1, powGrowth=1, defGrowth=1, spdGrowth=1, sklGrowth=1, intGrowth=1, lukGrowth=1;
	public final static double[] statGrowths = {1 , .7 , 1.2 , 1.3 , 1.7 , 1.5 , 1.9 , .9};
	public final static int expDrop=100;
	public final static int scrDrop=25;
	public static int MaxHp,CurrentHp,MaxBp,CurrentBp,BasePow,BuffedPow,BaseDef,BuffedDef,BaseSpd,BuffedSpd,BaseSkl,BuffedSkl,BaseInt,BuffedInt,BaseLuk,BuffedLuk;
	public int RedRes,BlueRes,GreenRes,YellRes,PurpRes,VoidRes;
	public int x = 300;
	public int y = 0;
	public static int[] baseStats=startStats;
	public static int[] buffedStats=baseStats;
	public static int[] tempStats={startStats[0],startStats[1]};
	public ArrayList<Skills> skills;
	public ArrayList<status> statuses;
	public BossJorge() {
//		super("Jorge",100,50, 12, 20, 17, 8, 10, 5,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"));
		super("Jorge",1,ImageLoader.loadImage("/CharacterBusts/3rdSouthOffices-5.png"), startStats, statGrowths);
		calcStats(1);
	}
	
	
	public Action getAction(BattleState bs){
		return new Action(this,bs.bp.allies.get((int)(Math.random()*bs.bp.allies.size())),new StandardAttack(0),bs);
		
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

}
